package com.oscar.retocsti.navigation.directions

import com.oscar.retocsti.navigation.NavigationCommand
import com.oscar.retocsti.navigation.NavigationRoute

object SignInNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "signIn"
    override val destination: String = route
}
