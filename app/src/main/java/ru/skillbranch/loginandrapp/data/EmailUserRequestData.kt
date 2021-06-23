package ru.skillbranch.loginandrapp.data

data class EmailUserRequestData(
    override val firstName: String,
    override val lastName: String,
    val email: String,
    val password: String
) : UserRequestData()
