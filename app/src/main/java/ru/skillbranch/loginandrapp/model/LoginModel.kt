package ru.skillbranch.loginandrapp.model

import ru.skillbranch.loginandrapp.data.AuthorizationApiService

class LoginModel(
    private val email: String? = "",
    private val password: String? = "",
    private val authorizationService: AuthorizationApiService = AuthorizationApiService.create()
) {
    suspend fun signIn(): Boolean {
        return authorizationService.signIn(email, password)
    }
}