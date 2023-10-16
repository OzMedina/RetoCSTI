package com.oscar.retocsti.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.domain.usescase.RegisterUseCase
import com.oscar.retocsti.navigation.NavigationManager
import com.oscar.retocsti.navigation.directions.HomeNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    private val registerUseCase: RegisterUseCase,
) :
    ViewModel() {
    private val _register = MutableStateFlow<Boolean?>(null)
    var register: StateFlow<Boolean?> = _register

    private fun goToHome() {
        navigationManager.navigate(HomeNavigation)
    }

    fun goToBackStack() {
        navigationManager.popBackStack()
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            registerUseCase(email = email, password = password).onStart {
            }.catch {
            }.collect {
                _register.value = it.data != null
                if (_register.value != null && _register.value!!) {
                    goToHome()
                }
            }
        }
    }
}
