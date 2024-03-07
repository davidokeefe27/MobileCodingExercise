package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    val extension: String,
    val path: String
)