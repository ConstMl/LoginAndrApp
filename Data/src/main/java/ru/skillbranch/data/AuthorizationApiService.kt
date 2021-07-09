package ru.skillbranch.data

import android.util.Log
import kotlinx.coroutines.delay
import ru.skillbranch.data.interfaces.IAuthorizationApiService

class AuthorizationApiService : IAuthorizationApiService {

    override suspend fun signIn(login: String?, password: String?) : Pair<Boolean, String> {
        delay(1500)
        Log.d("AuthorizationApiService", "login: $login, pass: $password")
        return Pair(login == "login", "")
    }

}