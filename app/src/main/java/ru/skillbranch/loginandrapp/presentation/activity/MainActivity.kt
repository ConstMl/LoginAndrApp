package ru.skillbranch.loginandrapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import org.koin.core.component.getScopeId
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.skillbranch.loginandrapp.R
import ru.skillbranch.loginandrapp.data.Navigator

class MainActivity : AppCompatActivity(), Navigator {

    lateinit var navController: NavController
    private lateinit var navModule: Module

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

        navModule = module {
            single<Navigator> { this@MainActivity }
        }
        loadKoinModules(navModule)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(navModule)
    }

    override fun navigate(url: String, args: Bundle?) {
        if (url == "app://welcome") {
//            val request = NavDeepLinkRequest.Builder
//                .fromUri(url.toUri())
//                .build()
            navController.navigate(R.id.welcomeFragment, args)
        } else {
            val text = "could not navigate to $url"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
        
    }
}