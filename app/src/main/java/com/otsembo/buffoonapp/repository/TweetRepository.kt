package com.otsembo.buffoonapp.repository

import com.otsembo.buffoonapp.model.User
import com.otsembo.buffoonapp.network.Tweet
import com.otsembo.buffoonapp.network.TweetService
import com.otsembo.buffoonapp.network.UserService

class TweetRepository(
    private val tweetService: TweetService,
    private val userService: UserService
) {

    // TODO: USE ROOM TO CACHE YOUR DATA
    // TODO: Server -> Room DB -> UI (LiveData) => READ DATA
    // TODO: CREATE USER => (UI -> Server -> Room DB -> UI)

    suspend fun getTweets(): List<Tweet> {
        return tweetService.getTweets()
    }

    suspend fun getUsers(): List<User> {
        return userService.getUsers()
    }

    suspend fun getTweetsFromUser(uid: Long): List<Tweet> {
        // random stuff
        return getTweets()
    }
}
