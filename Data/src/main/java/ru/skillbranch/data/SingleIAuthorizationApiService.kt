package ru.skillbranch.data

import android.util.Log
import kotlinx.coroutines.delay
import ru.skillbranch.data.interfaces.IAuthorizationApiService

class SingleIAuthorizationApiService : IAuthorizationApiService {

    companion object {
        private var singleAuthorizationApiService: SingleIAuthorizationApiService? = null
        val instance: IAuthorizationApiService
            get() {
                if (singleAuthorizationApiService == null) singleAuthorizationApiService = create()
                return singleAuthorizationApiService!!
            }
        private fun create(): SingleIAuthorizationApiService {
            return SingleIAuthorizationApiService()
        }
    }

    override suspend fun signIn(login: String?, password: String?): Boolean {
        delay(1500)
        Log.d("AuthorizationApiService", "login: $login, pass: $password")
        return login == "login"
    }

}