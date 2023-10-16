package com.oscar.retocsti.navigation.directions

import com.oscar.retocsti.navigation.NavigationCommand

object PopBackStack : NavigationCommand {
    override val destination: String = "popBackStack"
}
