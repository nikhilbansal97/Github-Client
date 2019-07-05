package com.app.nikhil.coroutinesessentials.ui.login

import androidx.lifecycle.MutableLiveData
import com.app.nikhil.coroutinesessentials.pojo.User
import com.app.nikhil.coroutinesessentials.ui.base.BaseViewModel
import com.app.nikhil.coroutinesessentials.ui.base.ViewState
import com.app.nikhil.coroutinesessentials.usecases.GetUserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel @Inject constructor(val getUserInfo: GetUserInfo) : BaseViewModel() {

  val viewStateLiveData = MutableLiveData<ViewState>()

  lateinit var user: User

  fun requestUserInfo(
    username: String,
    password: String
  ) {
    viewStateLiveData.value = ViewState.Loading
    viewModelScope.launch {
      val userInfoResponse = withContext(Dispatchers.IO) { getUserInfo(username, password) }
      if (userInfoResponse.isSuccessful && userInfoResponse.body() != null) {
        user = userInfoResponse.body()!!
        viewStateLiveData.postValue(ViewState.Success)
      } else {
        viewStateLiveData.postValue(ViewState.Error(Exception(userInfoResponse.errorBody()?.string())))
      }
    }
  }
}