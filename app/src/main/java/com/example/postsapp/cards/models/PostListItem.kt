package com.example.postsapp.cards.models

import com.example.postsapp.repositories.models.Post

sealed class PostListItem {
    data class Header(val letter: Char) : PostListItem()
    data class Item(val post: Post) : PostListItem()
}
