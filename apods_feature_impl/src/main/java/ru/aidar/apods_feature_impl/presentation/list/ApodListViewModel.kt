package ru.aidar.apods_feature_impl.presentation.list

import android.util.Log
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aidar.apods_feature_api.domain.interfaces.ApodListUseCases
import ru.aidar.apods_feature_api.domain.model.ApodLocal
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.common.base.BaseViewModel
import javax.inject.Inject

class ApodListViewModel
@Inject
constructor(
    private val router: ApodRouter,
    private val apodListUseCases: ApodListUseCases,
) : BaseViewModel() {

    init {
        Log.d("ViewModelInstance", "init ApodListViewModel")
    }

    fun getPictures(): Flow<PagingData<ApodLocal>> {
        return apodListUseCases.getPictures()
    }

    override fun onCleared() {
        Log.d("ViewModelInstance", "clear ApodListViewModel")
        super.onCleared()
    }

}
