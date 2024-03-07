package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)