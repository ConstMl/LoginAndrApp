package ru.skillbranch.loginandrapp

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.data.interfaces.IAuthorizationApiService
import ru.skillbranch.data.AuthorizationApiService
import ru.skillbranch.domain.interfaces.IAuthorizationRepository
import ru.skillbranch.data.repositories.AuthorizationRepository
import ru.skillbranch.domain.LoginModel
import ru.skillbranch.loginandrapp.model.viewmodel.LoginViewModel
import ru.skillbranch.loginandrapp.model.viewmodel.WelcomeViewModel

val loginModule = module {
    viewModel { LoginViewModel(get(), get()) }
    factory { LoginModel(get()) }
    single<IAuthorizationRepository> { AuthorizationRepository(get()) }
}

val welcomeModule = module {
    viewModel { (login: String) -> WelcomeViewModel(login) }
}

val authServiceModule = module {
    single<IAuthorizationApiService> { AuthorizationApiService() }
}

// val authServiceModule = module {
//    single<IAuthorizationApiService> { get<SingleIAuthorizationApiService>() }
//}
