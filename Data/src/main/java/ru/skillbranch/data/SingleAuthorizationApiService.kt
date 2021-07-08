package ru.skillbranch.data

import android.util.Log
import kotlinx.coroutines.delay
import ru.skillbranch.data.interfaces.IAuthorizationApiService

class SingleAuthorizationApiService : IAuthorizationApiService {

    override suspend fun signIn(login: String?, password: String?): Boolean {
        delay(1500)
        Log.d("AuthorizationApiService", "login: $login, pass: $password")
        return login == "login"
    }

}