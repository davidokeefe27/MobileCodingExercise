package com.example.mobilecodingexercise.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TextObject(
    val language: String,
    val text: String,
    val type: String
)