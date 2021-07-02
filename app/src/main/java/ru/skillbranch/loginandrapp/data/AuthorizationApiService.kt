package ru.skillbranch.loginandrapp.data

import android.util.Log
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.http.*

interface AuthorizationApiService {
    suspend fun signIn(login: String?, password: String?) : Boolean
}