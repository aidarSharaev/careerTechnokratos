package ru.aidar.apa_feature_impl.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
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
                VisibleApaSearchScreen(viewModel = viewModel)
            }
        }
        return view
    }
}
