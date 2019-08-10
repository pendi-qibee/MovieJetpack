package id.qibee.moviejetpack

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieListFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)
    private val tvShowFragment = TvShowFragment()

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        onView(withId(R.id.rvMovie)).check(matches(ViewMatchers.isDisplayed()))
//        onView(withId(R.id.rvMovie)).check(RecyclerViewItemCountAssertion(17))
    }
}