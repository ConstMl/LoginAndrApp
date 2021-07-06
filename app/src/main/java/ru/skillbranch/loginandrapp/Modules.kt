package ru.skillbranch.loginandrapp

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.data.AuthorizationApiService
import ru.skillbranch.data.SingleAuthorizationApiService
import ru.skillbranch.domain.LoginModel
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel
import ru.skillbranch.loginandrapp.model.viewmodel.WelcomeViewModel

val loginModule = module {
    viewModel { LoginViewModel(get(), get()) }
    factory { ru.skillbranch.domain.LoginModel(get()) }
    single<ru.skillbranch.data.AuthorizationApiService> { ru.skillbranch.data.SingleAuthorizationApiService() }
}

val welcomeModule = module {
    viewModel { (login: String) -> WelcomeViewModel(login) }
}