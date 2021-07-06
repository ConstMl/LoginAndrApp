package ru.skillbranch.domain

import ru.skillbranch.data.interfaces.IAuthorizationRepository

class LoginModel(
    private val authorizationRepository: IAuthorizationRepository
) {
    suspend fun signIn(login: String? = "", password: String? = ""): Boolean {
        return authorizationRepository.signIn(login, password)
    }
}