package com.app.nikhil.coroutinesessentials.injection.component

import com.app.nikhil.coroutinesessentials.injection.modules.AppModule
import com.app.nikhil.coroutinesessentials.injection.modules.ServiceModule
import com.app.nikhil.coroutinesessentials.injection.modules.ViewModelFactoryModule
import com.app.nikhil.coroutinesessentials.ui.login.LoginActivity
import com.app.nikhil.coroutinesessentials.ui.userinfo.UserInfoActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ServiceModule::class, ViewModelFactoryModule::class])
interface AppComponent {
  fun inject(target: LoginActivity)
  fun inject(target: UserInfoActivity)
}