package ru.skillbranch.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import retrofit2.http.*
import ru.skillbranch.data.interfaces.IRetrofitAuthorizationApiService

class RetrofitAuthorizationService : IRetrofitAuthorizationApiService {

    override suspend fun signIn(login: String?, password: String?): Pair<Boolean, String> {
        return Pair(login == "log", "") // вернуть ответ от сервера
    }

}