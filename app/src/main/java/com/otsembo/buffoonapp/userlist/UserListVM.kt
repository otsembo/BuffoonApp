package com.otsembo.buffoonapp.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otsembo.buffoonapp.model.User

class UserListVM : ViewModel() {
    private val userList: MutableLiveData<List<User>> = MutableLiveData(emptyList())
    val userAdapter = UserAdapter()
}
