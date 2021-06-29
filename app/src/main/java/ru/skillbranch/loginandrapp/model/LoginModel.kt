package ru.skillbranch.loginandrapp.model

import ru.skillbranch.loginandrapp.data.AuthorizationApiService

class LoginModel(
    private val authorizationService: AuthorizationApiService = AuthorizationApiService.create()
) {
    suspend fun signIn(email: String? = "", password: String? = ""): Boolean {
        return authorizationService.signIn(email, password)
    }
}