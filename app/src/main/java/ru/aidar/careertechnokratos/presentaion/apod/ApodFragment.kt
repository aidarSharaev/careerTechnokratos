package ru.aidar.careertechnokratos.presentaion.apod

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import ru.aidar.careertechnokratos.GpTurquoise
import ru.aidar.careertechnokratos.GpTypography
import ru.aidar.careertechnokratos.R
import ru.aidar.careertechnokratos.databinding.FragmentApodListBinding
import ru.aidar.careertechnokratos.di.GpDaggerViewModelFactory
import javax.inject.Inject

/**
 *
 * lifecycle
 *
 * */

class ApodFragment : Fragment() {
    private lateinit var binding: FragmentApodListBinding

    @Inject
    lateinit var viewModelFactory: GpDaggerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
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
                        style = GpTypography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent.copy(0.5f),
                    navigationIconContentColor = GpTurquoise,
                    titleContentColor = GpTurquoise,
                    actionIconContentColor = GpTurquoise,
                ),
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    ) {
        Box(
            modifier = Modifier.padding(it).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "This is $text")
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 40.dp)) {
                Text("Tap")
            }
        }
    }
}
