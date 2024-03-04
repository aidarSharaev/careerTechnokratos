package ru.aidar.careertechnokratos.base

import androidx.fragment.app.Fragment
import ru.aidar.careertechnokratos.di.AppComponent
import ru.aidar.careertechnokratos.di.GalaxyPulseApplication


class BaseFragment : Fragment() {


}

fun Fragment.getAppComponent(): AppComponent =
    (requireContext() as GalaxyPulseApplication).appComponent