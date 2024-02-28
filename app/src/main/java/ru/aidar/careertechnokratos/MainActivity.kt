package ru.aidar.careertechnokratos

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.aidar.careertechnokratos.databinding.ActivityMainBinding
import ru.aidar.careertechnokratos.di.appComponent

class MainActivity : AppCompatActivity() {

    //private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val dataSource = appComponent.nasaRemoteDataSource()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch(Dispatchers.IO) {
            val a = dataSource.get()
            //Log.d("KEYLEY222", a.near_earth_objects.size.toString())
            a.nearEarthObjects.forEach {
                Log.d("KEYLEY222", it.toString())
            }
        }
    }
}


