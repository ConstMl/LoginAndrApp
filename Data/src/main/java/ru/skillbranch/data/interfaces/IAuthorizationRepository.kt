package ru.skillbranch.data.interfaces

interface IAuthorizationRepository {
    suspend fun signIn(login: String?, password: String?) : Boolean
}