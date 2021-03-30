package com.example.appfilmes.Single_movie_details

import androidx.lifecycle.LiveData
import com.example.appfilmes.Data.api.TheMovieDBInterface
import com.example.appfilmes.Repository.MovieDetailsNetworkDataSource
import com.example.appfilmes.Repository.NetworkState
import com.example.appfilmes.Repository.NetworkStats
import com.example.appfilmes.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable


class MovieDetailsRepository(private val apiService : TheMovieDBInterface) {

    lateinit var MovieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fechSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {

         = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetWorkDataSource.fechMovieDetails(movieId)

        return movieDetalisNetworkDataSource.downloandMovieResponse
    }

        fun getMovieDetailsNetworkDataSource(): LiveData<NetworkState> {

            return getMovieDetailsNetworkDataSource()

        }
    }