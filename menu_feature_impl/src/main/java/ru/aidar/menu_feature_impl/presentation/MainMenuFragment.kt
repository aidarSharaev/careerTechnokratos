package ru.aidar.menu_feature_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.common.base.BaseFragment
import ru.aidar.menu_feature_impl.databinding.FragmentMainMenuBinding
import ru.aidar.menu_feature_impl.presentation.view.MainMenuScreen

class MainMenuFragment : BaseFragment<MainMenuViewModel>() {
    private lateinit var binding: FragmentMainMenuBinding

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun inject() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                MainMenuScreen(
//                    viewModel = viewModel,
                )
            }
        }
        return view
    }
}

/*
*
*     <string name="astrePerAstre">Astre per astre</string>
    <string name="spaceOverflow">Space Overflow</string>
    <string name="celestialCompatibility">Celestial Compatibility</string>
    <string name="astronomyPictureOfTheDay">Astronomy Picture of the Day</string>
    <string name="qwe">qwe</string>
    <string name="asdsda">sdasda</string>
*
* */
