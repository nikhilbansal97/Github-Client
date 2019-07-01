package com.app.nikhil.coroutinesessentials.injection

import com.app.nikhil.coroutinesessentials.BuildConfig
import com.app.nikhil.coroutinesessentials.network.AuthService
import com.app.nikhil.coroutinesessentials.ui.login.LoginViewModel
import com.app.nikhil.coroutinesessentials.usecases.AuthTokenUseCase
import com.app.nikhil.coroutinesessentials.usecases.GetUserInfo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}

val serviceModule = module {
    factory { get<Retrofit>().create(AuthService::class.java) }
}

val useCaseModule = module {
    single { AuthTokenUseCase(get()) }
    single { GetUserInfo(get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}
