package ru.aidar.apa_feature_impl.presentation.search

import androidx.compose.animation.scaleIn
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.aidar.apa_feature_api.domain.interfaces.SearchUseCases
import ru.aidar.apa_feature_api.domain.model.ScreenStatus
import ru.aidar.apa_feature_api.domain.wrappers.SearchState
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper
import ru.aidar.apa_feature_api.remote.ApaLocal
import ru.aidar.apa_feature_api.utils.Constants
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apa_feature_impl.data.model.toParce
import ru.aidar.common.base.BaseViewModel
import ru.aidar.common.monitor.NetworkMonitor
import kotlin.coroutines.CoroutineContext

class ApaSearchViewModel(
    private val router: ApaRouter,
    private val useCases: SearchUseCases,
    private val wrapper: SearchStateWrapper,
    private val monitor: NetworkMonitor
) : BaseViewModel(), CoroutineScope {

    val state = wrapper.flow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SearchState()
    )

    val isOffline = monitor.isOnline

    private var job: Job? = null

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + CoroutineName("ApaSearchViewModel")

    fun updateQuery(query: String) {
        wrapper.updateQuery(query = query)
        launch {
            job?.cancelAndJoin()
            if(query.isNotBlank())
                getObject(query)
            else
                wrapper.updateResponses(listOf(Constants.Earth, Constants.Venus, Constants.Mars))
        }
    }

    private fun getObject(query: String) {
        job = launch {
            val list = useCases.getObjects(regex = query)
            wrapper.updateResponses(list.data)
        }
    }

    fun updateActive(active: Boolean) {
        wrapper.updateActive(active = active)
    }

    fun updateStatus(status: ScreenStatus) {
        wrapper.updateStatus(status = status)
    }

    fun navigateToDetail(local: ApaLocal) {
        val action =
            SearchFragmentDirections.actionSearchToAstre(local.toParce())
        router.navigateToApaDetail(action)
    }

    fun navigateUp() {
        router.apaNavigateUp()
    }

    override fun onCleared() {
        coroutineContext.cancelChildren()
        super.onCleared()
    }
}

