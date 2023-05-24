package com.example.postsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.cards.models.PostListItem
import com.example.postsapp.usecases.GetPostsWithHeadersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostsViewModel(
    private val getPostsWithHeaders: GetPostsWithHeadersUseCase
) : ViewModel() {
    private val _posts = MutableLiveData<List<PostListItem>>()
    val posts: LiveData<List<PostListItem>>
        get() = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = getPostsWithHeaders.execute()
            _posts.postValue(posts)
        }
    }
}