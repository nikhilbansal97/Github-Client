package com.app.nikhil.coroutinesessentials

import android.app.Application
import com.app.nikhil.coroutinesessentials.injection.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(koinModule)
        }
    }
}