package com.example.mobilecodingexercise.api

import com.example.mobilecodingexercise.models.Comics
import com.example.mobilecodingexercise.models.Data
import com.example.mobilecodingexercise.repos.MarvelComicsRepo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("comics/294")
    suspend fun getComic(
        @Query("apikey")apikey:String = Constants.API_KEY,
        @Query("ts")ts:String = Constants.timeStamp,
        @Query("hash")hash:String = Constants.hash
    ): Response<Comics>
}