package com.oscar.retocsti.home

import androidx.lifecycle.ViewModel
import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.directions.SignInNavigation
import com.oscar.retocsti.navigation.directions.SignUpNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val navigationManager: NavigationManager) :
    ViewModel() {

    fun goToSignIn() {
        navigationManager.navigate(SignInNavigation)
    }

    fun goToSignUp() {
        navigationManager.navigate(SignUpNavigation)
    }
}
