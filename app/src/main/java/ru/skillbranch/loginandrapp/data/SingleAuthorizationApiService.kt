package ru.skillbranch.loginandrapp.data

import android.util.Log
import kotlinx.coroutines.delay

class SingleAuthorizationApiService : AuthorizationApiService {

    companion object {
        private var singleAuthorizationApiService: SingleAuthorizationApiService? = null
        val instance: AuthorizationApiService
            get() {
                if (singleAuthorizationApiService == null) singleAuthorizationApiService = create()
                return singleAuthorizationApiService!!
            }
        private fun create(): SingleAuthorizationApiService {
            return SingleAuthorizationApiService()
        }
    }

    override suspend fun signIn(login: String?, password: String?): Boolean {
        delay(1500)
        Log.d("AuthorizationApiService", "login: $login, pass: $password")
        return login == "login"
    }

}