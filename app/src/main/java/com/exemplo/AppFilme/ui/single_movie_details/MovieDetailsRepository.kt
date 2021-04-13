package com.exemplo.AppFilme.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.exemplo.AppFilme.data.api.TheMovieInterface
import com.exemplo.AppFilme.data.repository.MovieDetailsNetworkDataSource
import com.exemplo.AppFilme.data.repository.NetworkState
import com.exexplo.AppFilme.data.vo.MovieDetails

import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieInterface) {

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