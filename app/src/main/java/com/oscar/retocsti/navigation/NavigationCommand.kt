package com.oscar.retocsti.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {
    val destination: String
}

interface NavigationRoute {
    val route: String
    val arguments: List<NamedNavArgument> get() = emptyList()
}
