package ru.aidar.careertechnokratos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.aidar.careertechnokratos.databinding.ActivityMainBinding
import ru.aidar.careertechnokratos.di.appComponent

import ru.aidar.careertechnokratos.remote.NasaRemoteDataSource
import javax.inject.Inject

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
            Log.d("KEYLEY", a.toString())
        }
    }
}

