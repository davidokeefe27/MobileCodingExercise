package com.example.mobilecodingexercise

import com.example.mobilecodingexercise.comicDetail.ComicDetailUiModel
import com.example.mobilecodingexercise.comicDetail.comicToUiModel
import com.example.mobilecodingexercise.models.Characters
import com.example.mobilecodingexercise.models.Comics
import com.example.mobilecodingexercise.models.Creators
import com.example.mobilecodingexercise.models.Data
import com.example.mobilecodingexercise.models.Events
import com.example.mobilecodingexercise.models.Result
import com.example.mobilecodingexercise.models.Series
import com.example.mobilecodingexercise.models.Stories
import com.example.mobilecodingexercise.models.TextObject
import com.example.mobilecodingexercise.models.Thumbnail
import org.junit.Assert
import org.junit.Test

class ToUiModelUnitTest {
    private val correctAnswerUiTest = ComicDetailUiModel(
        "Title",
        "Summary",
        "Image.jpg",
    )
    private val characters = Characters(
        0,
        "",
        emptyList(),
        0
    )
    private val result = Result(
        characters = characters,
        collectedIssues = emptyList(),
        collections = emptyList(),
        creators = Creators(0, "", emptyList(), 0),
        dates = emptyList(),
        description = "",
        diamondCode = "",
        digitalId = 0,
        ean = "",
        events = Events(0,"", emptyList(), 0),
        format = "",
        id = 0,
        images = emptyList(),
        isbn = "",
        issn = "",
        issueNumber = 0,
        modified = "",
        pageCount = 0,
        prices = emptyList(),
        resourceURI = "",
        series = Series(
            "",
            ""
        ),
        stories = Stories(
            0,
            "",
            emptyList(),
            0
        ),
        textObjects = listOf(
            TextObject(
                "",
                "Summary",
                ""
            )
        ),
        thumbnail = Thumbnail(
            "jpg",
            "Image"
        ),
        title = "Title",
        upc = "",
        urls = emptyList(),
        variantDescription = "",
        variants = emptyList()
    )
    private val comicForTesting = Comics(
        "",
        "",
        0,
        "",
        Data(
            0,
            0,
            0,
            listOf(result),
            0
        ),
        "",
        ""
    )

    @Test
    fun comicToUiModel_isCorrect() {
        val result = comicToUiModel(comicForTesting)
        Assert.assertEquals(correctAnswerUiTest.coverImg, result.coverImg)
        Assert.assertEquals(correctAnswerUiTest.title, result.title)
        Assert.assertEquals(correctAnswerUiTest.summary, result.summary)
    }


}