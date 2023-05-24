package com.example.postsapp.di

import com.example.postsapp.repositories.mappers.PostMapper
import com.example.postsapp.repositories.mappers.PostMapperImpl
import org.koin.dsl.module

val mapperModule = module {
    single<PostMapper> {
        PostMapperImpl()
    }
}