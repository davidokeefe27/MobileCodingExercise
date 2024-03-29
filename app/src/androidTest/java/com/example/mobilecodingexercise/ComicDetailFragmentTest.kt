package com.example.mobilecodingexercise

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComicDetailFragmentTest {
    @Test
    fun testComicScreen() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.close)).check(matches(isDisplayed()))
        onView(withId(R.id.itemDetailHeader)).check(matches(isDisplayed()))
        onView(withId(R.id.the_story)).check(matches(isDisplayed()))
    }

}