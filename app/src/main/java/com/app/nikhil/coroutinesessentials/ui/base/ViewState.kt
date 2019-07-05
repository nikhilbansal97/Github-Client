package com.app.nikhil.coroutinesessentials.ui.base

sealed class ViewState {
  object Loading : ViewState()
  object Success : ViewState()
  class Error<T : Throwable>(val error: T) : ViewState()
}