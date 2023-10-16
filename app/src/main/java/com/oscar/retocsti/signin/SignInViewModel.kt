package com.oscar.retocsti.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.domain.usescase.LoginUseCase
import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.directions.ListNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val loginUseCase: LoginUseCase,
) :
    ViewModel() {
    private val _login = MutableStateFlow<Boolean?>(null)
    var login: StateFlow<Boolean?> = _login

    private fun goToList() {
        navigationManager.navigate(ListNavigation)
    }

    fun goToBackStack() {
        navigationManager.popBackStack()
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email = email, password = password).onStart {
            }.catch {
            }.collect {
                if (it.data != null) {
                    goToList()
                } else {
                    _login.value = false
                }
            }
        }
    }
}
