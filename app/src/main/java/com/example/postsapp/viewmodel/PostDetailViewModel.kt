package com.example.postsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.services.PostService
import com.example.postsapp.services.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostDetailViewModel(
    private val postService: PostService,
    private val postId: Int
) : ViewModel() {
    init {
        getPost()
    }

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post>
        get() = _post

    private fun getPost() {
        viewModelScope.launch(Dispatchers.IO) {
            val post = postService.getPostById(postId)
            _post.postValue(post)
        }
    }
}
