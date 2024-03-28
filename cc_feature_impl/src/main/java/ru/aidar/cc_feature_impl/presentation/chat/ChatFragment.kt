package ru.aidar.cc_feature_impl.presentation.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.aidar.cc_feature_api.di.CcFeatureApi
import ru.aidar.cc_feature_impl.databinding.FragmentChatBinding
import ru.aidar.cc_feature_impl.di.CcFeatureComponent
import ru.aidar.cc_feature_impl.presentation.chat.view.ChatScreen
import ru.aidar.common.base.BaseFragment
import ru.aidar.common.di.FeatureUtils

class ChatFragment : BaseFragment<ChatViewModel>() {
    private lateinit var binding: FragmentChatBinding

    override fun inject() {
        FeatureUtils.getFeature<CcFeatureComponent>(this, CcFeatureApi::class.java)
            .chatComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentChatBinding.inflate(inflater)
        val view = binding.root
        binding.composeChatView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val state by viewModel.state.collectAsStateWithLifecycle()
                ChatScreen(viewModel = viewModel, state = state)
            }
        }
        return view
    }
}
