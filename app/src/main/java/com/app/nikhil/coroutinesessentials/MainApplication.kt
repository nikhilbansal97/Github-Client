package com.app.nikhil.coroutinesessentials

import android.app.Application
import com.app.nikhil.coroutinesessentials.injection.component.AppComponent
import com.app.nikhil.coroutinesessentials.injection.component.DaggerAppComponent
import com.app.nikhil.coroutinesessentials.injection.modules.AppModule
import com.app.nikhil.coroutinesessentials.injection.modules.ServiceModule

class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .serviceModule(ServiceModule())
            .build()
    }
}