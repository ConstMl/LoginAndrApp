package ru.skillbranch.loginandrapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LoginAndrApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LoginAndrApp)
            modules(
                retrofitProviderModule,
                retrofitAuthorizationServiceModule,
                authServiceModule,
                loginModule,
                welcomeModule
            )
        }
    }
}