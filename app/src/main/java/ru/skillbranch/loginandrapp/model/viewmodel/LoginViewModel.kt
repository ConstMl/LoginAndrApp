package ru.skillbranch.loginandrapp.model.viewmodel

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import ru.skillbranch.loginandrapp.data.Navigator
import ru.skillbranch.loginandrapp.model.LoginModel
import ru.skillbranch.loginandrapp.presentation.activity.MainActivity
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
                navigator.navigate("app://welcome", Bundle())
            } else {
                error.value = "Sign in failed"
            }
            isLoading.value = false
        }
    }

    fun exitApp(): Unit = exitProcess(0)
}