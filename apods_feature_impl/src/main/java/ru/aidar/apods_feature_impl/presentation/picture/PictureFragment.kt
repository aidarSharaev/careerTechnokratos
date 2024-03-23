package ru.aidar.apods_feature_impl.presentation.picture

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.navArgs
import ru.aidar.apods_feature_api.di.ApodFeatureApi
import ru.aidar.apods_feature_impl.databinding.FragmentPictureBinding
import ru.aidar.apods_feature_impl.di.ApodFeatureComponent
import ru.aidar.apods_feature_impl.presentation.list.model.ParcelableLocal
import ru.aidar.apods_feature_impl.presentation.picture.view.PictureScreen
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils

class PictureFragment : BaseFragment<PictureViewModel>() {

    private lateinit var binding: FragmentPictureBinding

    private val args: PictureFragmentArgs by navArgs()

    override fun inject() {
        FeatureUtils.getFeature<ApodFeatureComponent>(this, ApodFeatureApi::class.java)
            .pictureComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPictureBinding.inflate(inflater)
        val view = binding.root
        val picture = try {
            args.pictureInfo
        } catch(e: Exception) {
            Log.d("SaveArgs", "--- $e")
        }
        binding.composePictureDetailView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                PictureScreen(viewModel = viewModel, picture = picture as ParcelableLocal)
            }
        }
        return view
    }
}
