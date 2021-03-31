package com.example.appfilmes.vo

import com.google.gson.annotations.SerializedName

class movie (
    val id: Int,
            @SerializedName("poster_path")
            val posterPath: String,
                    @SerializedName("release_date")
                    val releaseDate: String,
                    val title: String

)