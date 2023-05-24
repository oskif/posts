package com.example.postsapp.services

import com.example.postsapp.services.models.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface PostService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Post
}