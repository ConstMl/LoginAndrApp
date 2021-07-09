package ru.skillbranch.data.interfaces

interface IAuthorizationApiService {
    suspend fun signIn(login: String?, password: String?) : Pair<Boolean, String>
}