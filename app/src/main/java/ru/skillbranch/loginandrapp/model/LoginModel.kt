package ru.skillbranch.loginandrapp.model

import ru.skillbranch.loginandrapp.data.AuthorizationApiService

class LoginModel(
    private val authorizationService: AuthorizationApiService
) {
    suspend fun signIn(login: String? = "", password: String? = ""): Boolean {
        return authorizationService.signIn(login, password)
    }
}