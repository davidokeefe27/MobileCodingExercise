package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Thumbnail(
    val extension: String,
    val path: String
)