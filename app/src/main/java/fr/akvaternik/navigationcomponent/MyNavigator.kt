package fr.akvaternik.navigationcomponent

import android.os.Bundle
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

@Navigator.Name("custom")
class MyNavigator : Navigator<MyNavigator.Destination>() {
    override fun navigate(destination: Destination, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Extras?): NavDestination? {
        // Perform navigation here.
        return null
    }

    override fun createDestination(): Destination {
        return Destination(this)
    }

    override fun popBackStack(): Boolean {
        return false
    }

    class Destination(navigator: MyNavigator) : NavDestination(navigator)
}