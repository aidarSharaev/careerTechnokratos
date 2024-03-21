package ru.aidar.apods_feature_impl.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.apods_feature_api.di.ApodFeatureApi
import ru.aidar.apods_feature_impl.databinding.FragmentApodListBinding
import ru.aidar.apods_feature_impl.di.ApodFeatureComponent
import ru.aidar.apods_feature_impl.presentation.list.view.VisibleApodListScreen
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils

/**
 *
 * lifecycle
 *
 * */

class ApodListFragment : BaseFragment<ApodListViewModel>() {
    private lateinit var binding: FragmentApodListBinding

    override fun inject() {
        FeatureUtils.getFeature<ApodFeatureComponent>(this, ApodFeatureApi::class.java)
            .apodListComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentApodListBinding.inflate(inflater)
        val view = binding.root
        binding.composeApodLazyColumnView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                VisibleApodListScreen(viewModel = viewModel)
            }
        }
        return view
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GpApodList(text: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pictures",
                        style = AppTypography.titleLargeTypo,
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent.copy(0.5f),
                    navigationIconContentColor = AppTurquoise,
                    titleContentColor = AppTurquoise,
                    actionIconContentColor = AppTurquoise,
                ),
                navigationIcon = {
                    IconButton(onClick = { */
// do something
/* }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                        )
                    }
                },
            )
        },
    ) {

    }
}*/
