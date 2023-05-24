package com.example.postsapp.di

import com.example.postsapp.repositories.PostsRepository
import com.example.postsapp.repositories.PostsRepositoryImpl
import org.koin.dsl.module

val reposytoryModule = module {
    single<PostsRepository> {
        PostsRepositoryImpl(postService = get(), postMapper = get())
    }
}