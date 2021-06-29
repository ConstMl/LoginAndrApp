package ru.skillbranch.loginandrapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.loginModule

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        startKoin {
            androidContext(this@MainActivity)
            modules(loginModule)
        }
    }
}