package ru.skillbranch.loginandrapp.model.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.skillbranch.loginandrapp.data.Navigator
import ru.skillbranch.loginandrapp.model.LoginModel
import kotlin.system.exitProcess

class LoginViewModel(private val loginModel: LoginModel, private val navigator: Navigator) : ViewModel() {

    var login = MutableLiveData("")
    var password = MutableLiveData("")
    var error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>(false)

    fun onClickSignIn() { // suspend
        Log.d("onClickSignIn: ", "login: ${login.value}, pass: ${password.value}")
        viewModelScope.launch(Dispatchers.Main) {
            isLoading.value = true
            val res = loginModel.signIn(login = login.value, password = password.value)
            if (res) {
                val bundle = Bundle()
                bundle.putString("login", login.value)
                navigator.navigate("app://welcome", bundle)
            } else {
                error.value = "Sign in failed"
            }
            isLoading.value = false
        }
    }

    fun exitApp(): Unit = exitProcess(0)
}