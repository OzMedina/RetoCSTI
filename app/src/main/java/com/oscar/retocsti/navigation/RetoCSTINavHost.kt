package com.oscar.retocsti.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.oscar.retocsti.home.HomeScreen
import com.oscar.retocsti.list.ListScreen
import com.oscar.retocsti.navigation.directions.HomeNavigation
import com.oscar.retocsti.navigation.directions.ListNavigation
import com.oscar.retocsti.navigation.directions.PopBackStack
import com.oscar.retocsti.navigation.directions.SignInNavigation
import com.oscar.retocsti.navigation.directions.SignUpNavigation
import com.oscar.retocsti.signin.SignInScreen
import com.oscar.retocsti.signup.SignUpScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun RetoCSTINavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigation.destination,
    ) {
        composable(HomeNavigation.route) { HomeScreen() }
        composable(SignInNavigation.route) { SignInScreen() }
        composable(SignUpNavigation.route) { SignUpScreen() }
        composable(ListNavigation.route) { ListScreen() }
    }
}

@Composable
fun HandleNavigationCommands(
    navigationManager: NavigationManager,
    navController: NavController,
) {
    LaunchedEffect(key1 = Unit) {
        navigationManager.commands
            .onEach { command ->
                when (command.destination) {
                    PopBackStack.destination -> navController.popBackStack()
                    else -> navController.navigate(route = command.destination)
                }
            }
            .launchIn(this)
    }
}
