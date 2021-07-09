package ru.skillbranch.data.interfaces

import retrofit2.Retrofit

interface IRetrofitProvider {
    fun getClient(baseUrl: String): Retrofit
}