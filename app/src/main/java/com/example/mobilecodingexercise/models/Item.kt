package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    val name: String,
    val resourceURI: String,
    val role: String
)