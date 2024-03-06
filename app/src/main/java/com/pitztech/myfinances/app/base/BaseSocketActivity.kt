package com.pitztech.myfinances.base

abstract class BaseSocketActivity : BaseActivity<BaseSocketViewModel>() {

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