package ru.aidar.careertechnokratos

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.aidar.careertechnokratos.di.deps.findComponentDependencies
import ru.aidar.careertechnokratos.di.main.MainComponent
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.common.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject
    lateinit var navigator: Navigator

    private var navController: NavController? = null

    override fun initViews() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment).navController
        if (viewModel.isUserAuthorized()) {
            navigator.attachNavController(navController!!, R.navigation.nav_graph)
        } else {
            navigator.attachNavController(navController!!, R.navigation.nav_graph)
        }
    }

    override fun inject() {
        MainComponent.init(this, findComponentDependencies()).inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.let {
            navigator.detachNavController(it)
        }
    }
}
