package ru.skillbranch.loginandrapp.data

class Auth {
    lateinit var response: UserData
    private set

    fun request(requestData: UserRequestData) {}
}