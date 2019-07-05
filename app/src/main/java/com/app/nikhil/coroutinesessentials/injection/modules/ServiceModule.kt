package com.app.nikhil.coroutinesessentials.injection.modules

import com.app.nikhil.coroutinesessentials.network.AuthService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

  @Provides
  @Singleton
  fun provideAuthService(retrofit: Retrofit): AuthService {
    return retrofit.create(AuthService::class.java)
  }
}