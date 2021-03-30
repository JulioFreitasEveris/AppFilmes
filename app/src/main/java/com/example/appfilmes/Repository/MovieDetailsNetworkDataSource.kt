package com.example.appfilmes.Repository



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appfilmes.Data.api.TheMovieDBInterface
import com.example.appfilmes.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers



class MovieDetailsNetworkDataSource(private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable){

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState:LiveData<NetworkState>
        get() = _networkState

    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetails>()
    val downloadedMovieResponse:LiveData<MovieDetails>
        get() = _downloadedMovieDetailsResponse

    fun fechMovieDetails(filmeId: Int){

        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getMovieDetails(filmeId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {

                        },
                        {



                        }
                    )
            )
        }
        catch (e: Exception){

            }
        }

    fun fetchMovieDetails(movieId: Int) {
        TODO("Not yet implemented")
    }

}


