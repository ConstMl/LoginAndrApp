package ru.skillbranch.loginandrapp.data

data class EmailUserRegisterData(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
) : UserRequestData()
