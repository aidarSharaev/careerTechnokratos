package ru.aidar.apa_feature_impl.presentation.search

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import ru.aidar.apa_feature_api.domain.interfaces.SearchUseCases
import ru.aidar.apa_feature_api.domain.model.ScreenStatus
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper
import ru.aidar.apa_feature_api.remote.ApaLocal
import ru.aidar.apa_feature_api.utils.Constants
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apa_feature_impl.data.model.toParce
import ru.aidar.common.base.BaseViewModel
import kotlin.coroutines.CoroutineContext

class ApaSearchViewModel(
    private val router: ApaRouter,
    private val useCases: SearchUseCases,
    private val wrapper: SearchStateWrapper,
) : BaseViewModel(), CoroutineScope {

    val state = wrapper.flow()

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
            //useCases.getObjects(regex = query)
        }
    }

    private fun getObject(query: String) {
        job = launch {
            val list = useCases.getObjects(regex = query)
            wrapper.updateResponses(list)
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
}

