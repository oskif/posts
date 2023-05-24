package com.example.postsapp.repositories.models

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val userId: Int
)