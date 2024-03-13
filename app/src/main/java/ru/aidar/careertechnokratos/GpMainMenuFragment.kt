package ru.aidar.careertechnokratos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ru.aidar.careertechnokratos.databinding.FragmentGpMainMenuBinding
import ru.aidar.careertechnokratos.presentaion.apod.GpApodList

class GpMainMenuFragment : Fragment() {

    private lateinit var binding: FragmentGpMainMenuBinding
    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth

    var int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        currentUser?.let { int = 1 }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGpMainMenuBinding.inflate(inflater)
        val view = binding.root
        binding.mainMenuComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                if (int == 1) {
                    GpMainMenuScreen {
                        view.findNavController().navigate(R.id.action_mainMenu_to_apodDestination)
                    }
                } else {
                    GpApodList("registration")
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
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = GpTypography.titleLarge.copy(
                            shadow = Shadow(
                                color = GpBlack,
                                offset = Offset(2f, 2f),
                                blurRadius = 4f
                            )
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GpBlack,
                    navigationIconContentColor = GpTurquoise,
                    titleContentColor = GpTurquoise,
                    actionIconContentColor = GpTurquoise,
                ),
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_sun),
                            contentDescription = "Localized description",
                            modifier = Modifier.size(35.dp),
                            //modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                },
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                )
                .background(GpBlack)
        ) {
            item {// imagesDestination
                GpMainMenuItem(
                    color = GpYellow,
                    onClick = onClick,
                    image = R.drawable.ic_galaxy,
                    text = R.string.astronomyPictureOfTheDay,
                )
            }
            item {// neosDestination
                GpMainMenuItem(
                    color = GpBlue,
                    image = R.drawable.ic_asteroid,
                    text = R.string.nearEarthObject,
                )
            }
            item {// astreDestination
                GpMainMenuItem(
                    color = GpGreen,
                    image = R.drawable.ic_planet,
                    text = R.string.astrePerAstre,
                )
            }
            item {// testDestination
                GpMainMenuItem(
                    color = GpRed,
                    image = R.drawable.ic_rocket,
                    text = R.string.spaceOverflow,
                )
            }
            item {// loveDestination
                GpMainMenuItem(
                    color = GpPink,
                    image = R.drawable.ic_tarot,
                    text = R.string.celestialCompatibility
                )
            }
        }
    }
}

@Composable
fun GpMainMenuItem(
    color: Color,
    onClick: () -> Unit = {},
    @DrawableRes image: Int,
    @StringRes text: Int,
) {
    ElevatedCard(
        onClick = { onClick() },
        modifier = Modifier
            .height(170.dp)
            .padding(horizontal = 28.dp)
            .padding(top = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(id = text),
                style = GpTypography.menuText.copy(
                    shadow = Shadow(
                        color = GpBlack,
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                ),
                textAlign = TextAlign.Start
            )
        }
    }
}


@Preview(showBackground = true, device = "id:pixel_6_pro")
@Composable
fun GpMainMenuScreenPreview() {
    GpMainMenuScreen(onClick = {})
}



