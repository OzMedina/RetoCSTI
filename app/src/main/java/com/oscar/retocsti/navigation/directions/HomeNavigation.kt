package com.oscar.retocsti.navigation.directions

import com.oscar.retocsti.navigation.NavigationCommand
import com.oscar.retocsti.navigation.NavigationRoute

object HomeNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "home"
    override val destination: String = route
}
