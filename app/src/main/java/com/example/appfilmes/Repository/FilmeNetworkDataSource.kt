package com.example.appfilmes.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appfilmes.Data.Api.FilmesDBInterface
import com.example.appfilmes.vo.DetalhesDoFilme
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers.io
import java.lang.Exception


class FilmeNetworkDataSource (private val apiService : FilmesDBInterface,
                              private val compositeDisposable: CompositeDisposable){

    private val _network = MutableLiveData<Network>()
    val network : LiveData<Network>
        get() = _network

    private val _BaixadoDetalhesFilmeResponse = MutableLiveData<DetalhesDoFilme>()
    val dowloandedFilmeResponse : LiveData<DetalhesDoFilme>
        get() = _BaixadoDetalhesFilmeResponse

    fun BuscarDetalhesFilme(filmeId: Int) {

        _network.postValue(Network.LOADING)

        try {

            compositeDisposable.add(
                apiService.getDetalhesDoFilme(filmeId)
                    .subscribeOn(Scheduler.io())
                    .subscribe()
            )

        }
        catch (e: Exception){

        }
    }


}