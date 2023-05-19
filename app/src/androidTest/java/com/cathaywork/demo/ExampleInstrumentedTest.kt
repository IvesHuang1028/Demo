package com.cathaywork.demo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.cathaywork.demo.view.inital.SplashActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.cathaywork", appContext.packageName)
    }
    @get:Rule
    val activityTestRule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun testSplashActivity() {
        /**
         *  利用espresso 做 ui test
         *  確保有顯示
         */
        onView(withId(R.id.lottie)).check(matches(isDisplayed()))
    }
}