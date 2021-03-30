@file:Suppress("DEPRECATION")

package com.example.appfilmes.Repository

import android.graphics.Movie
import androidx.lifecycle.MutableLiveData
import com.example.appfilmes.Data.api.TheMovieDBInterface
import io.reactivex.disposables.CompositeDisposable
import javax.sql.DataSource

class MovieDataSourceFactory(private val apiService : TheMovieDBInterface,
                             private val compositeDisposable: CompositeDisposable)
                                                            : DataSource.Factory<Int, Movie> {
    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

                              override fun create(): DataSource<Int, Movie>{
                                  val movieDataSource = MovieDataSource(apiService, compositeDisposable)

                              moviesLiveDataSource.postValue(movieDataSource)
                              return movieDataSource


                              }
}