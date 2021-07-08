package ru.skillbranch.data.interfaces

interface RetrofitAuthorizationService : IAuthorizationApiService {
    override suspend fun signIn(login: String?, password: String?): Boolean
}

/*
* http - 1
* koin:
* (get(instOfRetrofit))
*
* */