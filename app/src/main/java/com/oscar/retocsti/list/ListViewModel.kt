package com.oscar.retocsti.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.domain.usescase.GetUsersByPageUseCase
import com.oscar.retocsti.model.UserModel
import com.oscar.retocsti.model.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getUsersByPageUseCase: GetUsersByPageUseCase) :
    ViewModel() {
    private val _users = MutableStateFlow<List<UserModel>>(emptyList())
    var users: StateFlow<List<UserModel>> = _users

    init {
        getUsersByPage()
    }

    fun getUsersByPage() {
        viewModelScope.launch {
            getUsersByPageUseCase().onStart {
            }.catch {
            }.collect {
                _users.value = it.data!!.toModel()
            }
        }
    }
}
