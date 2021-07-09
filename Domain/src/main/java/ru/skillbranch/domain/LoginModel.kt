package ru.skillbranch.domain

import ru.skillbranch.domain.interfaces.IAuthorizationRepository

class LoginModel(
    private val authorizationRepository: IAuthorizationRepository
) {
    suspend fun signIn(login: String? = "", password: String? = "") : Pair<Boolean, String> {
        return authorizationRepository.signIn(login, password)
    }
}