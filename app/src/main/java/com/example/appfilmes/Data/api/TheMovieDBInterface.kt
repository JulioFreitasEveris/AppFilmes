package com.example.appfilmes.Data.api

import com.example.appfilmes.vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TheMovieDBInterface {
//    https://api.themoviedb.org/3/movie/550?api_key=5e1ae4c60a5ba26389109bd40111a3e6&page=1
//    https://api.themoviedb.org/3/movie/550?api_key=5e1ae4c60a5ba26389109bd40111a3e6
//    https://api.themoviedb.org/3/

   @GET("movie/popular")
   fun getPopularMovie(@Query("page")page: Int): Single<MovieResponse>

   @GET("movie/{movie_id}")
   fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
    
}

class MovieResponse {

}
