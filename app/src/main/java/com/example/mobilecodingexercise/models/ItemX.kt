package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemX(
    val name: String,
    val resourceURI: String,
    val type: String
)