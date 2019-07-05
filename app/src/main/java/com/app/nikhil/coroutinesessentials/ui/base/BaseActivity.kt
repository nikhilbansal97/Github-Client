package com.app.nikhil.coroutinesessentials.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.app.nikhil.coroutinesessentials.R
import com.app.nikhil.coroutinesessentials.utils.ViewModelFactory
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

abstract class BaseActivity<VM: ViewModel, B: ViewDataBinding> : AppCompatActivity() {

    lateinit var viewmodel: VM
    lateinit var dataBinding: B

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun getViewModelClass(): Class<VM>

    abstract fun getLayoutId(): Int

    abstract fun handleStateChange(viewState: ViewState)

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createLoadingDialog()
    }

    fun bindLayout(layoutId: Int) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    }

    private fun createLoadingDialog() {
        dialog = MaterialAlertDialogBuilder(this)
            .setView(R.layout.layout_loading)
            .setCancelable(false)
            .create()
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showProgress() {
        dialog.show()
    }

    fun hideProgress() {
        dialog.hide()
    }
}