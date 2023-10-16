package com.oscar.retocsti.list

import androidx.lifecycle.ViewModel
import com.oscar.retocsti.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : ViewModel() {
    val list = listOf(
        UserModel(
            id = 1,
            email = "aa@aa.com",
            lastName = "Lawson",
            firstName = "Michael",
            avatar = "https://reqres.in/img/faces/7-image.jpg",
        ),
        UserModel(
            id = 2,
            email = "bb@bb.com",
            lastName = "Ferguson",
            firstName = "Lindsay",
            avatar = "https://reqres.in/img/faces/8-image.jpg",
        ),
    )
    private val _users = MutableStateFlow<List<UserModel>>(list)
    var users: StateFlow<List<UserModel>> = _users
}
