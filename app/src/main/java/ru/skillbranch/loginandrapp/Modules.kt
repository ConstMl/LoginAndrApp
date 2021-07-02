package ru.skillbranch.loginandrapp

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.loginandrapp.data.AuthorizationApiService
import ru.skillbranch.loginandrapp.data.SingleAuthorizationApiService
import ru.skillbranch.loginandrapp.model.LoginModel
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel
import ru.skillbranch.loginandrapp.model.viewmodel.WelcomeViewModel

val loginModule = module {
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginModel(get()) }
    single<AuthorizationApiService> { SingleAuthorizationApiService() }
}

val welcomeModule = module {
    viewModel { (login: String) -> WelcomeViewModel(login) }
}