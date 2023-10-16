package com.oscar.retocsti.signup

import androidx.lifecycle.ViewModel
import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.directions.SignInNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val navigationManager: NavigationManager) :
    ViewModel() {

    fun goToSignIn() {
        navigationManager.navigate(SignInNavigation)
    }

    fun goToBackStack() {
        navigationManager.popBackStack()
    }
}
