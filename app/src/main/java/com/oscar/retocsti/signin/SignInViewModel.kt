package com.oscar.retocsti.signin

import androidx.lifecycle.ViewModel
import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.directions.ListNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val navigationManager: NavigationManager) :
    ViewModel() {
    fun goToList() {
        navigationManager.navigate(ListNavigation)
    }

    fun goToBackStack() {
        navigationManager.popBackStack()
    }
}
