package com.otsembo.buffoonapp.network

import com.otsembo.buffoonapp.model.ServerResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TweetService {

    @POST("/tweet/post")
    suspend fun createTweet(@Body tweet: Tweet): ServerResponse

    @GET("/tweet/list")
    suspend fun getTweets(): List<Tweet>
}

data class Tweet(
    val id: Long,
    val text: String
)
