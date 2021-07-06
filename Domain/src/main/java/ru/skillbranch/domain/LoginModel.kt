package ru.skillbranch.domain

import ru.skillbranch.data.AuthorizationApiService

class LoginModel(
    private val authorizationService: ru.skillbranch.data.AuthorizationApiService
) {
    suspend fun signIn(login: String? = "", password: String? = ""): Boolean {
        return authorizationService.signIn(login, password)
    }
}