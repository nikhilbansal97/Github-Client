package com.app.nikhil.coroutinesessentials.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.nikhil.coroutinesessentials.pojo.User
import com.app.nikhil.coroutinesessentials.ui.base.BaseViewModel
import com.app.nikhil.coroutinesessentials.usecases.GetUserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(private val getUserInfo: GetUserInfo) : BaseViewModel() {

  private val _userInfoLiveData = MutableLiveData<User>()
  val userInfoLiveData: LiveData<User>
    get() = _userInfoLiveData

  private val _errorLiveData = MutableLiveData<Exception>()
  val errorLiveData: LiveData<Exception>
    get() = _errorLiveData

  fun requestUserInfo(
    username: String,
    password: String
  ) {
    viewModelScope.launch {
      val userInfoResponse = withContext(Dispatchers.IO) { getUserInfo(username, password) }
      if (userInfoResponse.isSuccessful) {
        _userInfoLiveData.value = userInfoResponse.body()
      } else {
        _errorLiveData.value = Exception(userInfoResponse.errorBody()?.string())
      }
    }
  }
}