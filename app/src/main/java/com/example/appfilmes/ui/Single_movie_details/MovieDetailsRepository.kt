package com.example.appfilmes.ui.Single_movie_details


import androidx.lifecycle.LiveData
import com.example.appfilmes.Data.api.TheMovieDBInterface
import com.example.appfilmes.Repository.MovieDetailsNetworkDataSource
import com.example.appfilmes.Repository.NetworkState
import com.example.appfilmes.vo.MovieDetails

import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}