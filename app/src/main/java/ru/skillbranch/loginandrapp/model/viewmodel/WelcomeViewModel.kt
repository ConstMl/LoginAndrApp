package ru.skillbranch.loginandrapp.model.viewmodel

import androidx.lifecycle.ViewModel

class WelcomeViewModel(login: String) : ViewModel() {

    var welcomeText: String? = null

    init {
        welcomeText = "Welcome, $login"
    }

}