package com.example.appfilmes.ui


import com.google.gson.annotations.SerializedName

data class MoveResponse(
        val page: Int,
        @SerializedName("results")
        val movieList : List<movie>,
        @SerializedName("Total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResults: Int

)

