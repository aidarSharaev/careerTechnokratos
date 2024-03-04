package ru.aidar.careertechnokratos.presentaion.neo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import ru.aidar.careertechnokratos.R
import ru.aidar.careertechnokratos.databinding.FragmentApodListBinding
import ru.aidar.careertechnokratos.databinding.FragmentNeoBinding
import ru.aidar.careertechnokratos.presentaion.apod.GpApodList


class NeoFragment : Fragment() {

    private lateinit var binding: FragmentNeoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentNeoBinding.bind(view)
        binding.composeNeoView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                GpApodList("NeoFragment")
            }
        }
    }
}