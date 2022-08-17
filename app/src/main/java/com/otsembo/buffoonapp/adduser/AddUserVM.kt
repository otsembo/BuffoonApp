package com.otsembo.buffoonapp.adduser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.otsembo.buffoonapp.model.User

class AddUserVM : ViewModel() {
    val userData: MutableLiveData<User> = MutableLiveData()

    fun createUser() {
    }

    fun updateUser() {
    }
}
