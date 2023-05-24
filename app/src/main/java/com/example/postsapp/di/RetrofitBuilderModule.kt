package com.example.postsapp.di

import com.example.postsapp.services.PostService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitBuilderModule = module {
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }

    single {
        get<Retrofit>().create(PostService::class.java)
    }
}