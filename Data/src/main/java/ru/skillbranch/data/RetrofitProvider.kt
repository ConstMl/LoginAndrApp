package ru.skillbranch.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.skillbranch.data.interfaces.IRetrofitProvider

// нужен ли интерфейс, если в kotlin есть тип object (singleton) ?
// в таком случае получается не нужна регистрация в koin
// или сделать RetrofitProvider обычным классом?
object RetrofitProvider : IRetrofitProvider {
    private var retrofit: Retrofit? = null

    override fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}