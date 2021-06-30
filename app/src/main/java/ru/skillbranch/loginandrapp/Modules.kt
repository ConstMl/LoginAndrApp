package ru.skillbranch.loginandrapp

import androidx.navigation.navDeepLink
import org.koin.dsl.module
import org.koin.dsl.single
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.loginandrapp.data.AuthorizationApiService
import ru.skillbranch.loginandrapp.data.Navigator
import ru.skillbranch.loginandrapp.model.LoginModel
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel
import ru.skillbranch.loginandrapp.presentation.activity.MainActivity

val loginModule = module {
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginModel(AuthorizationApiService.instance) }
    single<AuthorizationApiService>()
}

val navModule = module {
    single<Navigator> { MainActivity() }
}