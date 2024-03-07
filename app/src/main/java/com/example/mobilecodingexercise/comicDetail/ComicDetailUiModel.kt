package com.example.mobilecodingexercise.comicDetail

import android.net.Uri
import com.example.mobilecodingexercise.models.Comics
import com.example.mobilecodingexercise.models.Url

class ComicDetailUiModel(
    val title: String,
    val summary: String,
    val coverImg: String,
)

fun comicToUiModel(comics: Comics?): ComicDetailUiModel{
    val comicAns = comics?.data?.results?.first()
    return ComicDetailUiModel(
        title = comicAns?.title.orEmpty(),
        summary = comicAns?.textObjects?.first()?.text.orEmpty(),
        coverImg = "${comicAns?.thumbnail?.path.orEmpty()}.${comicAns?.thumbnail?.extension.orEmpty()}",
    )
}