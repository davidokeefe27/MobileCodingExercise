package com.example.mobilecodingexercise.models

import com.example.mobilecodingexercise.models.ItemX
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)