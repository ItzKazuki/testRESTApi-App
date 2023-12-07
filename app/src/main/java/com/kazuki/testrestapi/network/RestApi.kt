package com.kazuki.testrestapi.network

import com.kazuki.testrestapi.model.Post
import com.kazuki.testrestapi.model.User
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {
    @GET("/users")
    suspend fun getDataUser(): Response<List<User>>

    @GET("/posts")
    suspend fun getAllPosts(): Response<Post>
}