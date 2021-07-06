package ru.skillbranch.loginandrapp.data

interface AuthorizationApiService {
    suspend fun signIn(login: String?, password: String?) : Boolean
}