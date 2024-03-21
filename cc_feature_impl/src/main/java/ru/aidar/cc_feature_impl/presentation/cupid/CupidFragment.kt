package ru.aidar.cc_feature_impl.presentation.cupid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.cc_feature_api.di.CcFeatureApi
import ru.aidar.cc_feature_impl.databinding.FragmentCupidBinding
import ru.aidar.cc_feature_impl.di.CcFeatureComponent
import ru.aidar.cc_feature_impl.presentation.cupid.view.CupidScreen
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils

class CupidFragment : BaseFragment<CupidViewModel>() {

    private lateinit var binding: FragmentCupidBinding

    override fun inject() {
        FeatureUtils.getFeature<CcFeatureComponent>(this, CcFeatureApi::class.java)
            .cupidComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCupidBinding.inflate(inflater)
        val view = binding.root
        binding.composeCupidView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CupidScreen(viewModel = viewModel)
            }
        }
        return view
    }
}