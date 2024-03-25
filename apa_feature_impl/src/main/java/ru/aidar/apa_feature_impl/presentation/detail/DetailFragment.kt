package ru.aidar.apa_feature_impl.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.navArgs
import ru.aidar.apa_feature_api.di.ApaFeatureApi
import ru.aidar.apa_feature_impl.databinding.FragmentDetailBinding
import ru.aidar.apa_feature_impl.di.ApaFeatureComponent
import ru.aidar.apa_feature_impl.presentation.detail.view.ApaDetailScreen
import ru.aidar.apa_feature_impl.presentation.detail.view.VisibleApaDetailScreen
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils

class DetailFragment : BaseFragment<ApaDetailViewModel>() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun inject() {
        FeatureUtils.getFeature<ApaFeatureComponent>(this, ApaFeatureApi::class.java)
            .detailComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)
        val view = binding.root
        val apa = args.astre
        binding.apaDetailComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                VisibleApaDetailScreen(viewModel = viewModel, apa = apa)
            }
        }
        return view
    }
}
