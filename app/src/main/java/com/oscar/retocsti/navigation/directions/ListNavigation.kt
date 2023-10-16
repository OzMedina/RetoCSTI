package com.oscar.retocsti.navigation.directions

import com.oscar.retocsti.navigation.NavigationCommand
import com.oscar.retocsti.navigation.NavigationRoute

object ListNavigation : NavigationRoute, NavigationCommand {
    override val route: String = "list"
    override val destination: String = route
}
