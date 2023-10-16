package com.oscar.retocsti.navigation.directions

import com.oscar.retocsti.navigation.NavigationCommand
import com.oscar.retocsti.navigation.NavigationRoute

object SignUpNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "signUp"
    override val destination: String = route
}
