package com.app.nikhil.coroutinesessentials.network

import com.app.nikhil.coroutinesessentials.pojo.Token
import com.app.nikhil.coroutinesessentials.pojo.User
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface AuthService {

    @POST("/authorizations")
    fun getAuthToken(
        @HeaderMap headers: Map<String, String>,
        @Body body: RequestBody
    ): Call<Token>

    @GET("/user")
    fun getUserInfo(@HeaderMap headers: Map<String, String>): Call<User>
}