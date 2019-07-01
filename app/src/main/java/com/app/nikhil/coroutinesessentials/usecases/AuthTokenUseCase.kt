package com.app.nikhil.coroutinesessentials.usecases

import com.app.nikhil.coroutinesessentials.BuildConfig
import com.app.nikhil.coroutinesessentials.network.AuthService
import com.app.nikhil.coroutinesessentials.pojo.Token
import com.app.nikhil.coroutinesessentials.utils.HttpConstants
import com.app.nikhil.coroutinesessentials.utils.HttpConstants.HEADER_AUTHORIZATION
import com.app.nikhil.coroutinesessentials.utils.HttpConstants.HEADER_CLIENT_ID
import com.app.nikhil.coroutinesessentials.utils.HttpConstants.HEADER_CLIENT_SECRET
import com.app.nikhil.coroutinesessentials.utils.HttpConstants.HEADER_SCOPE
import com.app.nikhil.coroutinesessentials.utils.createBase64Encoding
import kotlinx.coroutines.coroutineScope
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.awaitResponse

class AuthTokenUseCase(private val authService: AuthService) : BaseUseCase() {

    suspend operator fun invoke(username: String, password: String): Response<Token> {
        return coroutineScope {
            val headers = createTokenHeaders(username, password)
            val body = createTokenBody()
            authService.getAuthToken(headers, body).awaitResponse()
        }
    }

    private fun createTokenHeaders(username: String, password: String): HashMap<String, String> {
        val headers = HashMap<String, String>()
        headers[HEADER_CLIENT_ID] = BuildConfig.CLIENT_ID
        headers[HEADER_CLIENT_SECRET] = BuildConfig.CLIENT_SECRET
        headers[HEADER_SCOPE] = "[\"public_repo\"]"
        headers[HEADER_AUTHORIZATION] = """Basic ${createBase64Encoding(username, password)}"""
        return headers
    }

    private fun createTokenBody(): RequestBody {
        val body = "{ \"note\": \"Koin App\" }"
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body)
    }
}