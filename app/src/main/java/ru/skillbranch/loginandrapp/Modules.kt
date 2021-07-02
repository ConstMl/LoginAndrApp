package ru.skillbranch.loginandrapp

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.loginandrapp.data.AuthorizationApiService
import ru.skillbranch.loginandrapp.data.SingleAuthorizationApiService
import ru.skillbranch.loginandrapp.model.LoginModel
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel

val loginModule = module {
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginModel(get()) }
    single<AuthorizationApiService> { SingleAuthorizationApiService() }
}