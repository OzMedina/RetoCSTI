package com.oscar.retocsti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.oscar.retocsti.navigation.HandleNavigationCommands
import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.RetoCSTINavHost
import com.oscar.retocsti.ui.theme.RetoCSTITheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoCSTITheme {
                val navController = rememberNavController()

                RetoCSTINavHost(navController = navController)
                HandleNavigationCommands(
                    navigationManager = navigationManager,
                    navController = navController,
                )
            }
        }
    }
}
