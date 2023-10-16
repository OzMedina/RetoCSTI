package com.oscar.retocsti.navigation.directions

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.oscar.retocsti.navigation.NavigationCommand
import com.oscar.retocsti.navigation.NavigationRoute
import com.oscar.retocsti.navigation.utils.appendTitleNavArguments
import com.oscar.retocsti.navigation.utils.appendTitleParams

object SignInNavigation : NavigationRoute {
    private const val path = "signIn"
    override val route: String = "$path/{${ArgumentKeys.EMAIL}}".appendTitleParams()
    override val arguments: List<NamedNavArgument> = listOf(
        navArgument(ArgumentKeys.EMAIL) {
            type = NavType.StringType
            defaultValue = ""
        },
    ).appendTitleNavArguments()

    fun withEmail(
        email: String = "",
    ) = object : NavigationCommand {
        override val destination: String
            get() = "$path/$email"
    }
}
