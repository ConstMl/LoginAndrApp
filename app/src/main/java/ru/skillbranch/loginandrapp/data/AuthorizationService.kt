package ru.skillbranch.loginandrapp.data

interface AuthorizationService {
    val accessToken: String
    suspend fun signIn(data: UserEmailAuthData) : Boolean // set access token
    suspend fun isSign(data: UserEmailAuthData) : Boolean
}