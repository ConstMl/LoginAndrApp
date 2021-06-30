package ru.skillbranch.loginandrapp.model.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import ru.skillbranch.loginandrapp.data.Navigator
import ru.skillbranch.loginandrapp.model.LoginModel
import kotlin.system.exitProcess

class LoginViewModel(private val loginModel: LoginModel, private val navigator: Navigator) : ViewModel() {

    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var error = MutableLiveData<String>()
    var isLoading = MutableLiveData<Boolean>(false)

    fun onClickSignIn() { // suspend
        Log.d("onClickSignIn: ", "login: ${email.value}, pass: ${password.value}")
        viewModelScope.launch(Dispatchers.Main) {
            isLoading.value = true
            loginModel.signIn(email = email.value, password = password.value)
            isLoading.value = false
        }
//        navigator.navigate("app://welcome")
//        this.loginModel.signIn(email = email.value, password = password.value)
    }

    fun exitApp(): Unit = exitProcess(0)
}