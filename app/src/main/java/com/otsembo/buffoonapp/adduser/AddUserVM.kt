package com.otsembo.buffoonapp.adduser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.otsembo.buffoonapp.model.User
import com.otsembo.buffoonapp.network.NetworkUtils
import com.otsembo.buffoonapp.network.Tweet
import com.otsembo.buffoonapp.repository.TweetRepository
import kotlinx.coroutines.launch

class AddUserVM : ViewModel() {
    private val initialUser = User(name = "", email = "", age = 0)
    val userData: MutableLiveData<User> = MutableLiveData(initialUser)

    val tweets: MutableLiveData<List<Tweet>> = MutableLiveData(emptyList())

    val repository = TweetRepository(tweetService = NetworkUtils.tweetService, userService = NetworkUtils.userService)

    init {
        viewModelScope.launch {
            // repository.getTweetsFromUser(0L)
        }
    }

    fun createUser() {
        // TODO: Using data binding update id and age
        viewModelScope.launch {
            val user = userData.value
            if (user != null) {
                NetworkUtils.userService.createUser(user)
            }
        }
    }

    fun updateUser() {
        viewModelScope.launch {
            val user = userData.value
            if (user != null) {
                NetworkUtils.userService.updateUser(3, user)
            }
        }
    }
}
