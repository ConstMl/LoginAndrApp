package ru.skillbranch.data.repositories

import ru.skillbranch.data.interfaces.IAuthorizationApiService
import ru.skillbranch.domain.interfaces.IAuthorizationRepository

class AuthorizationRepository(
    private val authorizationApiService: IAuthorizationApiService
    ) : IAuthorizationRepository {

    override suspend fun signIn(login: String?, password: String?): Boolean {
        return authorizationApiService.signIn(login, password)
    }

}