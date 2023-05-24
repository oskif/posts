package com.example.postsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsapp.cards.CardAdapter
import com.example.postsapp.cards.models.PostListItem
import com.example.postsapp.databinding.ActivityPostsBinding
import com.example.postsapp.viewmodel.PostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostsBinding
    private val viewModel by viewModel<PostsViewModel>()
    private val cardAdapter = CardAdapter() { post ->
        startActivity(PostDetailsActivity.newInent(this@PostsActivity, post.post.id))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@PostsActivity)
            adapter = this@PostsActivity.cardAdapter
        }

        viewModel.posts.observe(this) { posts ->
            cardAdapter.setItems(posts)
        }
    }
}