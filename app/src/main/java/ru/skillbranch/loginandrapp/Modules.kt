package ru.skillbranch.loginandrapp

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import ru.skillbranch.data.interfaces.IAuthorizationApiService
import ru.skillbranch.data.AuthorizationApiService
import ru.skillbranch.data.RetrofitAuthorizationService
import ru.skillbranch.data.RetrofitProvider
import ru.skillbranch.data.interfaces.IRetrofitAuthorizationApiService
import ru.skillbranch.data.interfaces.IRetrofitProvider
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
//    single<IAuthorizationApiService> { AuthorizationApiService() }
    single<IAuthorizationApiService> { get<IRetrofitProvider>().getClient(baseUrlLink).create(IRetrofitAuthorizationApiService::class.java) }
}

val retrofitAuthorizationServiceModule = module {
    single<IRetrofitAuthorizationApiService> { RetrofitAuthorizationService() }
}

val retrofitProviderModule = module {
    single<IRetrofitProvider> { RetrofitProvider() }
}

// val authServiceModule = module {
//    single<IAuthorizationApiService> { get<SingleIAuthorizationApiService>() }
//}
