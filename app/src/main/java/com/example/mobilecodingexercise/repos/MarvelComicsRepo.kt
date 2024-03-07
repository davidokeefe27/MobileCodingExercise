package com.example.mobilecodingexercise.repos

import com.example.mobilecodingexercise.api.Api
import com.example.mobilecodingexercise.models.Comics
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp
import javax.inject.Inject

interface MarvelComicsRepo {
    suspend fun getComic(): Response<Comics>
}

class MarvelComicsRepoImpl @Inject constructor() : MarvelComicsRepo {
    private var api: Api




    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        api = retrofit.create()
    }


    override suspend fun getComic(): Response<Comics> {
        return api.getComic()
    }

}

@Module
@InstallIn(ViewModelComponent::class)
abstract class MarvelComicsModule {
    @Binds
    abstract fun bindMarvelComicsRepo(repoImpl: MarvelComicsRepoImpl): MarvelComicsRepo
}