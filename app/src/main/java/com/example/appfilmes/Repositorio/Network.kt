package com.example.appfilmes.Repositorio

import android.provider.VoicemailContract
import androidx.loader.content.Loader

enum class status{
    RUNNING,
    SUCCESS,
    FAILED
}

class Network(val status: status, val msg: String) {

    companion object{
        val LOADED: Network
        val LOADING: Network
        val ERROR: Network

        init {
            LOADED = Network(status.SUCCESS,"Success")
            LOADING= Network(status.RUNNING,"Running")
            ERROR  = Network(status.FAILED,"Something went wrong")
        }
    }

}