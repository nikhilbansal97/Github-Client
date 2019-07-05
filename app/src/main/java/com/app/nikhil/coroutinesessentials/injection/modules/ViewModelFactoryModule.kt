package com.app.nikhil.coroutinesessentials.injection.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.nikhil.coroutinesessentials.injection.multibinding.ViewModelKey
import com.app.nikhil.coroutinesessentials.ui.login.LoginViewModel
import com.app.nikhil.coroutinesessentials.ui.userinfo.UserInfoViewModel
import com.app.nikhil.coroutinesessentials.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  @IntoMap
  @ViewModelKey(LoginViewModel::class)
  abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(UserInfoViewModel::class)
  abstract fun bindUserInfoViewModel(userInfoViewModel: UserInfoViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}