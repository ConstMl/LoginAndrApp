package ru.skillbranch.data.repositories

import ru.skillbranch.data.interfaces.IAuthorizationApiService
import ru.skillbranch.data.interfaces.IAuthorizationRepository

class AuthorizationRepository(
    private val IAuthorizationApiService: IAuthorizationApiService
    ) : IAuthorizationRepository {

    override suspend fun signIn(login: String?, password: String?): Boolean {
        return IAuthorizationApiService.signIn(login, password)
    }

}