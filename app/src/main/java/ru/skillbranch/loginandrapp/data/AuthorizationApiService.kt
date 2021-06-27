package ru.skillbranch.loginandrapp.data

import ru.skillbranch.loginandrapp.model.UserEmailAuthData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.*

interface AuthorizationApiService {
//    val accessToken: String
//    suspend fun signIn(data: UserEmailAuthData) : Boolean // set access token
//    suspend fun isSign(data: UserEmailAuthData) : Boolean

    @POST("user/auth/local")
    suspend fun signIn(
        @Query("email") mail: String?,
        @Query("password") password: String?
    ) : Boolean

    companion object Factory {
        fun create(): AuthorizationApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://qwe.qwe.qwe/api/v3/")
                .build()
            return retrofit.create(AuthorizationApiService::class.java)
        }
    }
}