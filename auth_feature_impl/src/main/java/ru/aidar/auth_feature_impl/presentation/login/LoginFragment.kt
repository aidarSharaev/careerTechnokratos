package ru.aidar.auth_feature_impl.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.auth_feature_api.di.AuthFeatureApi
import ru.aidar.auth_feature_impl.di.AuthFeatureComponent
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils
import ru.aidar.signin_feature_impl.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<LoginViewModel>() {
    private lateinit var binding: FragmentLoginBinding

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun inject() {
        FeatureUtils.getFeature<AuthFeatureComponent>(this, AuthFeatureApi::class.java)
            .loginComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        val view = binding.root
        binding.loginComposeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                LoginScreen(viewModel = viewModel)
            }
        }
        return view
    }
}
