package com.example.postsapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postsapp.databinding.ActivityPostBinding
import com.example.postsapp.viewmodel.PostDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostDetailsActivity : AppCompatActivity() {
    private val viewModel: PostDetailViewModel by viewModel {
        parametersOf(
            intent.getIntExtra(
                KEY_POST_ID,
                MISSING_POST_ID
            )
        )
    }

    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.post.observe(this) {
            binding.tvTitle.text = it.title
            binding.tvBody.text = it.body
        }
    }

    companion object {
        private const val KEY_POST_ID = "KEY_POST_ID"
        private const val MISSING_POST_ID = -1

        fun newInent(context: Context, postId: Int): Intent =
            Intent(context, PostDetailsActivity::class.java).apply {
                putExtra(KEY_POST_ID, postId)
            }
    }
}