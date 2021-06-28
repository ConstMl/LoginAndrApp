package ru.skillbranch.loginandrapp.model.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.loginandrapp.model.LoginModel

class LoginViewModel(private val loginModel: LoginModel = LoginModel()) : ViewModel() {

    var email = MutableLiveData("qwe1")
    var password = MutableLiveData("ww")
    var error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>()

    fun signIn() { // suspend
        Log.d("onClickSignIn: ", "login: ${email.value}, pass: ${password.value}")
//        this.loginModel.signIn()
    }
}