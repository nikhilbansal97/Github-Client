package com.app.nikhil.coroutinesessentials.usecases

import com.app.nikhil.coroutinesessentials.network.AuthService
import com.app.nikhil.coroutinesessentials.pojo.User
import com.app.nikhil.coroutinesessentials.utils.HttpConstants.HEADER_AUTHORIZATION
import com.app.nikhil.coroutinesessentials.utils.createBase64Encoding
import kotlinx.coroutines.coroutineScope
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class GetUserInfo @Inject constructor(private val authService: AuthService) : BaseUseCase() {

  suspend operator fun invoke(username: String, password: String): Response<User> {
    return coroutineScope {
      val headers = createHeadersForUserRequest(username, password)
      authService.getUserInfo(headers).awaitResponse()
    }
  }

  private fun createHeadersForUserRequest(
    username: String,
    password: String
  ): HashMap<String, String> {
    val hashMap = HashMap<String, String>()
    hashMap[HEADER_AUTHORIZATION] = "Basic ${createBase64Encoding(username, password)}"
    return hashMap
  }

}