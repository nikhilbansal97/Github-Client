package com.app.nikhil.coroutinesessentials.ui.login

import android.os.Bundle
import androidx.lifecycle.Observer
import com.app.nikhil.coroutinesessentials.R
import com.app.nikhil.coroutinesessentials.ui.base.BaseActivity
import com.app.nikhil.coroutinesessentials.utils.animateFadeIn
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

class LoginActivity : BaseActivity<LoginViewModel>() {

  override val viewmodel: LoginViewModel by viewModel()

  override fun getViewModelKClass(): KClass<LoginViewModel> = LoginViewModel::class

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    initUi()
    setupObservers()
    setupListeners()
  }

  private fun initUi() {
    githubLabelImage.animateFadeIn()
  }

  private fun setupListeners() {
    loginButton.setOnClickListener {
      val username = etUsername.text.toString()
      val password = etPassword.text.toString()
      viewmodel.requestUserInfo(username, password)
    }
  }

  private fun setupObservers() {
    viewmodel.errorLiveData.observe(this, Observer {
      it?.let { exception -> showMessage(exception.message!!) }
    })

    viewmodel.userInfoLiveData.observe(this, Observer {
      it?.let { user -> showMessage(user.email) }
    })
  }
}
