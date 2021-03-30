package com.example.appfilmes.Single_movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.appfilmes.Repository.NetworkState
import com.example.appfilmes.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable


class SingleMovieViewModel(private val movieRepository: MovieDetailsRepository, movieId: Int): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails : LiveData<MovieDetails> by lazy {
        movieRepository.fechSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState =

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}