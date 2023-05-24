package com.example.postsapp.cards

import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.databinding.CardCellBinding
import com.example.postsapp.repositories.models.Post

class PostCardViewHolder(
    private val binding: CardCellBinding,
    onItemClicked: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun postBind(item: Post) {
        binding.title.text = item.title
        binding.body.text = item.body
    }
}