package com.example.postsapp.di

import com.example.postsapp.viewmodel.PostDetailViewModel
import com.example.postsapp.viewmodel.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PostsViewModel(get()) }

    viewModel { (postId: Int) ->
        PostDetailViewModel(get(), postId)
    }
}