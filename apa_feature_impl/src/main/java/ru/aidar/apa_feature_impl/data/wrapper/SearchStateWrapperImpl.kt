package ru.aidar.apa_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.aidar.apa_feature_api.domain.model.ScreenStatus
import ru.aidar.apa_feature_api.domain.wrappers.SearchState
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper
import ru.aidar.apa_feature_api.remote.ApaLocal

class SearchStateWrapperImpl(
    private val flow: MutableStateFlow<SearchState>,
) : SearchStateWrapper {

    override fun flow(): StateFlow<SearchState> {
        return flow
    }

    override fun updateQuery(query: String) {
        flow.update { it.copy(query = query) }
    }

    override fun updateActive(active: Boolean) {
        flow.update { it.copy(active = active) }
    }

    override fun updateStatus(status: ScreenStatus) {
        flow.update { it.copy(status = status) }
    }

    override fun updateResponses(responses: List<ApaLocal>) {
        flow.update { it.copy(responses = responses) }
    }
}
