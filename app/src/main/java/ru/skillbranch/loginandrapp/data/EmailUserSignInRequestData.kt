package ru.skillbranch.loginandrapp.data

data class EmailUserSignInRequestData(
    val email: String,
    val password: String
) : UserRequestData()
