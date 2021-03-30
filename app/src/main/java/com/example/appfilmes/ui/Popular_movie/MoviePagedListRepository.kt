package com.example.appfilmes.ui.Popular_movie

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.appfilmes.Data.api.POST_PER_PAGE
import com.example.appfilmes.Data.api.TheMovieDBInterface
import com.example.appfilmes.Repository.MovieDataSourceFactory
import com.example.appfilmes.Repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MoviePagedListRepository(private val apiService: TheMovieDBInterface) {
    lateinit var moviepageList: LiveData<PagedList<Movie>>
    lateinit var movieDataSourceFactory: MovieDataSourceFactory

    fun fechLiveMoviePagedList (compositeDisposable: CompositeDisposable):LiveData<PagedList<Movie>>{
        movieDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config:PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviepageList = LivePagedListBuilder (movieDataSourceFactory, config).build()
        return moviepageList

    }
    fun getNetworkState(): LiveData<NetworkState>{
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            movieDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState)

    }
}