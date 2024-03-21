package ru.aidar.menu_feature_impl.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils
import ru.aidar.menu_feature_api.di.MainMenuFeatureApi
import ru.aidar.menu_feature_impl.databinding.FragmentMainMenuBinding
import ru.aidar.menu_feature_impl.di.MainMenuFeatureComponent
import ru.aidar.menu_feature_impl.presentation.menu.view.MainMenuScreen

class MainMenuFragment : BaseFragment<MainMenuViewModel>() {

    private lateinit var binding: FragmentMainMenuBinding

    override fun inject() {
        FeatureUtils.getFeature<MainMenuFeatureComponent>(this, MainMenuFeatureApi::class.java)
            .mmComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainMenuBinding.inflate(inflater)
        val view = binding.root
        binding.mainMenuComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MainMenuScreen(viewModel = viewModel)
            }
        }
        return view
    }
}
