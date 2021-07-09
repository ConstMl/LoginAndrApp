package ru.skillbranch.data

import ru.skillbranch.data.interfaces.IAuthorizationApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.http.*

class RetrofitAuthorizationService : IAuthorizationApiService {

    @POST("user/auth/local")
    override suspend fun signIn(
        @Query("email") login: String?,
        @Query("password") password: String?
    ): Pair<Boolean, String> {
        TODO("Not yet implemented")
    }

}