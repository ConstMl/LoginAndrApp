package ru.skillbranch.loginandrapp.data

import android.util.Log
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.http.*

interface AuthorizationApiService {
    suspend fun signIn(login: String?, password: String?) : Boolean {
        delay(1500)
        Log.d("AuthorizationApiService", "login: $login, pass: $password")
        return login == "login"
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