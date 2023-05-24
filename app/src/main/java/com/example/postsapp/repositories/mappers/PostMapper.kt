package com.example.postsapp.repositories.mappers

import com.example.postsapp.services.models.Post as ServicePost
import com.example.postsapp.repositories.models.Post

interface PostMapper : Mapper<ServicePost, Post>

class PostMapperImpl : PostMapper {
    override suspend fun map(input: ServicePost): Post =
        Post(
            id = input.id,
            title = input.title,
            body = input.body,
            userId = input.userId
        )
}