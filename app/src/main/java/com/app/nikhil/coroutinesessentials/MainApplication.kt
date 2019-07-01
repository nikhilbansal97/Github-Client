package com.app.nikhil.coroutinesessentials

import android.app.Application
import com.app.nikhil.coroutinesessentials.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(appModule, serviceModule, viewModelModule, useCaseModule))
        }
    }
}