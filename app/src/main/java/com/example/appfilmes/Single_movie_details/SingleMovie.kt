package com.example.appfilmes.Single_movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.appfilmes.Data.api.TheMovieDBClient
import com.example.appfilmes.Data.api.TheMovieDBInterface
import com.example.appfilmes.R
import com.example.appfilmes.vo.MovieDetails
import kotlinx.android.synthetic.main.activity_unico_filme.*


class SingleMovie : AppCompatActivity() {

    private lateinit var viewModel: SingleMovieViewModel
    private lateinit var movieRepository: MovieDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unico_filme)

        val movieId: Int = 1

        val apiService: TheMovieDBInterface = TheMovieDBClient.getClient()
        movieRepository = MovieDetailsRepository(apiService)

        viewModel = getViewModel(movieId)

        viewModel.movieDetails.observe(this, Observer {
            bindUI(it)
        })
    }

   fun bindUI(it: MovieDetails?) {
       movie_title

    }

    private fun getViewModel (movieId:Int): SingleMovieViewModel{
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass : Class<T>): T {
                return SingleMovieViewModel(movieRepository, movieId) as T
            }
        })[SingleMovieViewModel::class.java]
        }
    }
