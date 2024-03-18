package ru.aidar.auth_feature_impl.presentation.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.auth_feature_api.di.AuthFeatureApi
import ru.aidar.auth_feature_impl.di.AuthFeatureComponent
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils
import ru.aidar.signin_feature_impl.databinding.FragmentCreateAccountBinding

class CreateAccountFragment : BaseFragment<CreateAccountViewModel>() {
    private lateinit var binding: FragmentCreateAccountBinding

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun inject() {
        FeatureUtils.getFeature<AuthFeatureComponent>(this, AuthFeatureApi::class.java)
            .createAccComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCreateAccountBinding.inflate(inflater)
        val view = binding.root
        binding.createComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CreateAccountScreen(viewModel = viewModel)
            }
        }
        return view
    }
}
