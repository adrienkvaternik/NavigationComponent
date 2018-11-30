package fr.akvaternik.navigationcomponent

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.mockk.*
import org.junit.Test

class HomeFragmentTest {

    @Test
    fun navigate_when_button_clicked() {
        // Given
        val scenario = launchFragmentInContainer<HomeFragment>()

        val navController = mockk<NavController>()
        every { navController.navigate(any() as NavDirections) } just Runs

        scenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.view!!, navController)
        }

        // When
        onView(withId(R.id.button)).perform(click())

        // Then
        val directions = HomeFragmentDirections.goToDetails().setName("Adrien")
        verify { navController.navigate(directions) }
    }
}
