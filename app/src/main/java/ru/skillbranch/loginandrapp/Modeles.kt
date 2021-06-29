package ru.skillbranch.loginandrapp

import androidx.lifecycle.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.dsl.single
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.loginandrapp.data.AuthorizationApiService
import ru.skillbranch.loginandrapp.model.LoginModel
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel

val loginModule = module {
    viewModel { LoginViewModel(get()) }
    factory { LoginModel(AuthorizationApiService.create()) }
    single<AuthorizationApiService>()
}