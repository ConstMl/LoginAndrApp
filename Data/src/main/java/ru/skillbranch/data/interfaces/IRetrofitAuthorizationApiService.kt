package ru.skillbranch.data.interfaces

import retrofit2.http.POST
import retrofit2.http.Query

interface IRetrofitAuthorizationApiService : IAuthorizationApiService {

    // в body необходимо передать
    // email и password
    // в ответ на запрос приходит статус и токен
    @POST("user/auth/local")
    override suspend fun signIn(
        @Query("email") login: String?,
        @Query("password") password: String?
    ): Pair<Boolean, String>

}