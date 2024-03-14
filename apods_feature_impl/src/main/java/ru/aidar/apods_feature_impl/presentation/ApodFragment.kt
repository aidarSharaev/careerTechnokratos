package ru.aidar.apods_feature_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import ru.aidar.apods_feature_impl.databinding.FragmentApodListBinding
import ru.aidar.common.utils.GpColors.GpTurquoise
import ru.aidar.common.utils.GpTypography

/**
 *
 * lifecycle
 *
 * */

class ApodFragment : Fragment() {
    private lateinit var binding: FragmentApodListBinding

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
                        style = GpTypography.titleLargeTypo,
                    )
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent.copy(0.5f),
                        navigationIconContentColor = GpTurquoise,
                        titleContentColor = GpTurquoise,
                        actionIconContentColor = GpTurquoise,
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
        Box(
            modifier =
                Modifier
                    .padding(it)
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "This is $text")
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 40.dp)) {
                Text("Tap")
            }
        }
    }
}
