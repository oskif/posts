package com.example.postsapp

import android.app.Application
import com.example.postsapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PostApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PostApp)
            modules(
                retrofitBuilderModule,
                viewModelModule,
                useCaseModule,
                reposytoryModule,
                mapperModule
            )
        }
    }
}