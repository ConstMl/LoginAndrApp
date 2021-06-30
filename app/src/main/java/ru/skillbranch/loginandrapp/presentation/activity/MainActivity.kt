package ru.skillbranch.loginandrapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.NavHostFragment
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.data.Navigator

class MainActivity : AppCompatActivity(), Navigator {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun navigate(url: String, args: Bundle?) {
        if (url == "app://welcome") {
            val request = NavDeepLinkRequest.Builder
                .fromUri(url.toUri())
                .build()
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
            val navController: NavController = navHostFragment.navController
            navController.navigate(request)
        } else {
            val text = "could not navigate to $url"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
        
    }
}