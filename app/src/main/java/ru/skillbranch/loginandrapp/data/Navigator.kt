package ru.skillbranch.loginandrapp.data

import android.os.Bundle

interface Navigator {
    fun navigate(url: String, args: Bundle?)
}