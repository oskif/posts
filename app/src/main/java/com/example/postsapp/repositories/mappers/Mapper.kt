package com.example.postsapp.repositories.mappers

interface Mapper<Input, Output> {
    suspend fun map(input: Input): Output
}