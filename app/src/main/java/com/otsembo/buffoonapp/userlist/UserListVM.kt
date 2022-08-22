package com.otsembo.buffoonapp.userlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otsembo.buffoonapp.model.User
import com.otsembo.buffoonapp.network.NetworkUtils
import kotlinx.coroutines.launch

class UserListVM : ViewModel() {
    val userList: MutableLiveData<List<User>> = MutableLiveData(emptyList())

    // TODO: Complete DELETE method

    init {
        viewModelScope.launch {
            val users = NetworkUtils.userService.getUsers()
            userList.value = users
        }
    }

    fun getUserTweets() {
        viewModelScope.launch {
            val users = NetworkUtils.userService.getUsers()
            val tweetData = NetworkUtils.tweetService.getTweets()
            // LOGIC HERE
        }
    }

    fun getTitleTweets(title: String) {
        viewModelScope.launch {
            val users = NetworkUtils.userService.getUsers()
            val tweetData = NetworkUtils.tweetService.getTweets()
            // OTHER LOGIC HERE
        }
    }
}
