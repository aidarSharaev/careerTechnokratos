package ru.aidar.careertechnokratos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.navigation.NavController
import androidx.navigation.findNavController
import ru.aidar.careertechnokratos.databinding.FragmentGpMainMenuBinding

class GpMainMenuFragment : Fragment() {

    private lateinit var binding: FragmentGpMainMenuBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGpMainMenuBinding.inflate(inflater)
        val view = binding.root
        //navController = view.findNavController()
        binding.mainMenuComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GpMainMenuScreen {
                    view.findNavController().navigate(R.id.action_mainMenu_to_apodList)
                }
            }
        }
        return view
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GpMainMenuScreen(onClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
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
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },

        ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(GpBlack)
        ) {
            item {// imagesDestination
                GpMainMenuItem(color = GpYellow, onClick = onClick)
            }
            item {// neosDestination
                GpMainMenuItem(color = GpBlue)
            }
            item {// astreDestination
                GpMainMenuItem(color = GpGreen)
            }
            item {// testDestination
                GpMainMenuItem(color = GpRed)
            }
            item {// loveDestination
                GpMainMenuItem(color = GpPink)
            }
        }
    }
}

@Composable
fun GpMainMenuItem(
    color: Color,
    onClick: () -> Unit = {}
) {
    ElevatedCard(
        onClick = { onClick() },
        modifier = Modifier
            .height(170.dp)
            .padding(horizontal = 28.dp)
            .padding(top = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text("asd")
        }
    }
}


//@Preview(showBackground = true, device = "id:pixel_6_pro")
//@Composable
//fun GpMainMenuScreenPreview() {
////    GpMainMenuScreen()
//}



