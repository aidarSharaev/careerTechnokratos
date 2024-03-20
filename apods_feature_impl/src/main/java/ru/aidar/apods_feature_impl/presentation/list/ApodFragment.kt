package ru.aidar.apods_feature_impl.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.apod_feature_impl.databinding.FragmentApodListBinding
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.utils.AppColors.AppTurquoise
import ru.aidar.common.utils.AppTypography

/**
 *
 * lifecycle
 *
 * */

class ApodFragment : BaseFragment<ApodViewModel>() {
    private lateinit var binding: FragmentApodListBinding

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun inject() {
        TODO("Not yet implemented")
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
                GpApodList("ApodFragment")
            }
        }
        return view
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
                    IconButton(onClick = { /* do something */ }) {
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
}
