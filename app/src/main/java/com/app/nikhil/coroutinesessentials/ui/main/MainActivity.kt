package com.app.nikhil.coroutinesessentials.ui.main

import android.os.Bundle
import android.widget.Toast
import com.app.nikhil.coroutinesessentials.R
import com.app.nikhil.coroutinesessentials.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import retrofit2.Retrofit

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    private val retrofit: Retrofit by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainText.text = retrofit.baseUrl().host()
    }
}
