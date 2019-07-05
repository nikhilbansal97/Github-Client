package com.app.nikhil.coroutinesessentials.ui.userinfo

import android.os.Bundle
import com.app.nikhil.coroutinesessentials.MainApplication
import com.app.nikhil.coroutinesessentials.R
import com.app.nikhil.coroutinesessentials.databinding.ActivityUserInfoBinding
import com.app.nikhil.coroutinesessentials.pojo.User
import com.app.nikhil.coroutinesessentials.ui.base.BaseActivity
import com.app.nikhil.coroutinesessentials.ui.base.ViewState
import com.app.nikhil.coroutinesessentials.utils.Constants

class UserInfoActivity : BaseActivity<UserInfoViewModel, ActivityUserInfoBinding>() {

  override fun getLayoutId(): Int = R.layout.activity_user_info

  override fun getViewModelClass(): Class<UserInfoViewModel> = UserInfoViewModel::class.java

  override fun handleStateChange(viewState: ViewState) {

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    init()
    val user = intent.getParcelableExtra<User>(Constants.BUNDLE_KEY_USER)
  }

  private fun init() {
    (application as MainApplication).appComponent.inject(this)
    bindLayout(getLayoutId())
  }
}
