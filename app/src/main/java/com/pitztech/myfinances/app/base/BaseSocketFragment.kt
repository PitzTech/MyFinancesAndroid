package com.pitztech.myfinances.base

abstract class BaseSocketFragment<VM : BaseSocketViewModel> : DaggerBaseFragment<VM>() {

    override fun setUpView() {
        super.setUpView()
        observeSocketState()
    }

    private fun observeSocketState() {

    }

    open fun onSocketConnecting() {

    }

    open fun onSocketDisconnected() {

    }

    open fun onSocketConnect() {

    }
}