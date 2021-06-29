package ru.skillbranch.loginandrapp.model.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.skillbranch.loginandrapp.model.LoginModel
import kotlin.system.exitProcess

class LoginViewModel(private val loginModel: LoginModel = LoginModel()) : ViewModel() {

    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    fun signIn() { // suspend
        Log.d("onClickSignIn: ", "login: ${email.value}, pass: ${password.value}")
//        this.loginModel.signIn()
    }

    fun exitApp(): Unit = exitProcess(0)
}