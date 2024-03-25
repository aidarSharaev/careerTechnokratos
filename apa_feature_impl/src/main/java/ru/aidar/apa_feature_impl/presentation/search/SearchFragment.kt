package ru.aidar.apa_feature_impl.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.aidar.apa_feature_api.di.ApaFeatureApi
import ru.aidar.apa_feature_impl.databinding.FragmentSearchBinding
import ru.aidar.apa_feature_impl.di.ApaFeatureComponent
import ru.aidar.apa_feature_impl.presentation.search.view.VisibleApaSearchScreen
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils

class SearchFragment : BaseFragment<ApaSearchViewModel>() {
    private lateinit var binding: FragmentSearchBinding

    override fun inject() {
        FeatureUtils.getFeature<ApaFeatureComponent>(this, ApaFeatureApi::class.java)
            .searchComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater)
        val view = binding.root
        binding.apaSearchComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val monitor by
                    viewModel.isOffline.collectAsStateWithLifecycle(initialValue = false)
                VisibleApaSearchScreen(viewModel = viewModel, monitor = monitor)
            }
        }
        return view
    }
}
