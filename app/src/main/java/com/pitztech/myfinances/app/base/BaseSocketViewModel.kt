package com.pitztech.myfinances.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pitztech.myfinances.domain.socketio.ISocket

abstract class BaseSocketViewModel : BaseViewModel() {

    private val socketState = MutableLiveData<ISocket.SocketState>()

    fun getSocketStateLv(): LiveData<ISocket.SocketState> {
        return socketState
    }
}