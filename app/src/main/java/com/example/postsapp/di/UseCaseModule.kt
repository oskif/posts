package com.example.postsapp.di

import com.example.postsapp.usecases.GetPostsWithHeadersUseCase
import com.example.postsapp.usecases.GetPostsWithHeadersUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetPostsWithHeadersUseCase> {
        GetPostsWithHeadersUseCaseImpl(postsRepository = get())
    }
}