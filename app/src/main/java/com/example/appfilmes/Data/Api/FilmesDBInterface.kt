package com.example.appfilmes.Data.Api

import com.example.appfilmes.vo.DetalhesDoFilme
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path



interface FilmesDBInterface {
//    https://api.themoviedb.org/3/movie/550?api_key=5e1ae4c60a5ba26389109bd40111a3e6&page=1
//    https://api.themoviedb.org/3/movie/550?api_key=5e1ae4c60a5ba26389109bd40111a3e6
//    https://api.themoviedb.org/3/
    
   @GET("movie/{movie_id}")
   fun getDetalhesDoFilme(@Path("movie_id") id: Int): Single<DetalhesDoFilme>
    
}