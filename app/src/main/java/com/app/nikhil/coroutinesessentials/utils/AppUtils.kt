package com.app.nikhil.coroutinesessentials.utils

import android.util.Base64

fun createBase64Encoding(username: String, password: String): String {
    val byteArray = "$username:$password".toByteArray()
    return Base64.encodeToString(byteArray, Base64.DEFAULT).trim()
}