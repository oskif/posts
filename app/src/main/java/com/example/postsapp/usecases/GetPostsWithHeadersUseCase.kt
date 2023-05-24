package com.example.postsapp.usecases

import com.example.postsapp.cards.models.PostListItem
import com.example.postsapp.repositories.PostsRepository
import com.example.postsapp.repositories.models.Post

interface GetPostsWithHeadersUseCase {
    suspend fun execute(): List<PostListItem>
}

class GetPostsWithHeadersUseCaseImpl(
    private val postsRepository: PostsRepository
) : GetPostsWithHeadersUseCase {

    override suspend fun execute(): List<PostListItem> {
        val postsMap: Map<Char, List<Post>> = postsRepository.getGroupedPostsByTitle()
        val postsHeaders = ArrayList<PostListItem>()

        for (item in postsMap) {
            postsHeaders.add(PostListItem.Header(item.key))
            postsHeaders.addAll(item.value.map { PostListItem.Item(it) })
        }
        return postsHeaders
    }
}