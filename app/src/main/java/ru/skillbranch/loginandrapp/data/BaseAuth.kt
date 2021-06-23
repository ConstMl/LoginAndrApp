package ru.skillbranch.loginandrapp.data

abstract class BaseAuth {
    lateinit var response: UserData
    private set

    fun request(requestData: UserRequestData) {}
}