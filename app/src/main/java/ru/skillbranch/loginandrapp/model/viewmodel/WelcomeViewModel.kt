package ru.skillbranch.loginandrapp.model.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    var login = MutableLiveData<String>("asd")

}