package ru.skillbranch.domain.interfaces

interface IAuthorizationRepository {
    suspend fun signIn(login: String?, password: String?) : Pair<Boolean, String>
}