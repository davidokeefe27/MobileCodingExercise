package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Series(
    val name: String,
    val resourceURI: String
)