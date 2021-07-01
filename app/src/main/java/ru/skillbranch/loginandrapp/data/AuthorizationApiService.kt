package ru.skillbranch.loginandrapp.data

import android.util.Log
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.http.*

interface AuthorizationApiService {
//    val accessToken: String
//    suspend fun signIn(data: UserEmailAuthData) : Boolean // set access token
//    suspend fun isSign(data: UserEmailAuthData) : Boolean

//    @POST("user/auth/local")
//    suspend fun signIn(
//        @Query("email") mail: String?,
//        @Query("password") password: String?
//    ) : Boolean

    suspend fun signIn(email: String?, password: String?) : Boolean {
        delay(3500)
        Log.d("AuthorizationApiService", "login: $email, pass: $password")
        return email == "email"
    }

    companion object SingleAuthorizationApiService : AuthorizationApiService {
        private var authorizationApiService: AuthorizationApiService? = null
        val instance: AuthorizationApiService
            get() {
                if (authorizationApiService == null) authorizationApiService = create()
                return authorizationApiService!!
            }
        private fun create(): AuthorizationApiService {
            return AuthorizationApiService
        }
    }

//    companion object SingleAuthorizationApiService {
//        private var authorizationApiService: AuthorizationApiService? = null
//
//        val instance: AuthorizationApiService
//            get() {
//                if (authorizationApiService == null) authorizationApiService = create()
//                return authorizationApiService!!
//            }
//
//        private fun create(): AuthorizationApiService {
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://qwe.qwe.qwe/api/v3/")
//                .build()
//            return retrofit.create(AuthorizationApiService::class.java)
//        }
//    }
}