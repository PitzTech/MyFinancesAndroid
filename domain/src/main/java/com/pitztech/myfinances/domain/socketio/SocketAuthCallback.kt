package com.pitztech.myfinances.domain.socketio

interface SocketAuthCallback {
        fun onAuthenticated(baseUrl: String, token: String)
        fun onAuthenticationError()
}