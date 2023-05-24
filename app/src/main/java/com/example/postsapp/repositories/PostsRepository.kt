package com.example.postsapp.repositories

import com.example.postsapp.repositories.mappers.PostMapper
import com.example.postsapp.services.PostService
import com.example.postsapp.repositories.models.Post

interface PostsRepository {
    suspend fun getGroupedPostsByTitle(): Map<Char, List<Post>>
    suspend fun getPosts(): List<Post>
}

class PostsRepositoryImpl(
    private val postService: PostService,
    private val postMapper: PostMapper
) : PostsRepository {

    override suspend fun getPosts(): List<Post> =
        postService.getPosts().map { item ->
            postMapper.map(item)
        }

    override suspend fun getGroupedPostsByTitle(): Map<Char, List<Post>> =
        getPosts().groupBy { it.title.first() }.toSortedMap()
}