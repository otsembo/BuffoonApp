package com.otsembo.buffoonapp.network

import com.otsembo.buffoonapp.model.ServerResponse
import com.otsembo.buffoonapp.model.User
import retrofit2.http.*

interface UserService {

    @POST("/user/create")
    suspend fun createUser(@Body user: User): ServerResponse

    @PUT("/user/update/{uid}")
    suspend fun updateUser(@Path("uid") uid: Long, @Body user: User): ServerResponse

    @DELETE("/user/delete/{uid}")
    suspend fun deleteUser(@Path("uid") uid: Long): ServerResponse

    @GET("/user/list")
    suspend fun getUsers(): List<User>
}
