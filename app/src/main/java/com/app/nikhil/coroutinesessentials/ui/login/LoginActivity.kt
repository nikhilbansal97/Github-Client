package com.app.nikhil.coroutinesessentials.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import com.app.nikhil.coroutinesessentials.MainApplication
import com.app.nikhil.coroutinesessentials.R
import com.app.nikhil.coroutinesessentials.databinding.ActivityLoginBinding
import com.app.nikhil.coroutinesessentials.ui.base.BaseActivity
import com.app.nikhil.coroutinesessentials.ui.base.ViewState
import com.app.nikhil.coroutinesessentials.ui.userinfo.UserInfoActivity
import com.app.nikhil.coroutinesessentials.utils.Constants
import com.app.nikhil.coroutinesessentials.utils.animateFadeIn
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {

  override fun getLayoutId(): Int = R.layout.activity_login

  override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initUi()
    setupObservers()
    setupListeners()
  }

  override fun handleStateChange(viewState: ViewState) {
    when (viewState) {
      is ViewState.Loading -> {
        showProgress()
      }
      is ViewState.Success -> {
        hideProgress()
        startNextActivity()
      }
      is ViewState.Error<*> -> {
        hideProgress()
        showMessage(viewState.error.message!!)
      }
    }
  }

  private fun startNextActivity() {
    val bundle = Bundle()
    bundle.putParcelable(Constants.BUNDLE_KEY_USER, viewmodel.user)
    val intent = Intent(this, UserInfoActivity::class.java)
    intent.putExtra(Constants.BUNDLE_KEY_USER, viewmodel.user)
    startActivity(intent)
    overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
  }

  private fun initUi() {
    (application as MainApplication).appComponent.inject(this)
    bindLayout(getLayoutId())
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
    viewmodel.viewStateLiveData.observe(this, Observer {
      it?.let { viewState -> handleStateChange(viewState) }
    })
  }
}
