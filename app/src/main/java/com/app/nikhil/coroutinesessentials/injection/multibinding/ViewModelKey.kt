package com.app.nikhil.coroutinesessentials.injection.multibinding

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/*
* Map MultiBinding to add the instances of ViewModels into the map
* so that ViewModelFactory can access them
*/
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey (val value: KClass<out ViewModel>)