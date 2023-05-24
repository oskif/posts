package com.example.postsapp.cards

import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.cards.models.PostListItem
import com.example.postsapp.databinding.HeaderCellBinding

class HeaderCardViewHolder(private val binding: HeaderCellBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun headerBind(header: PostListItem.Header) {
        binding.header.text = header.letter.toString()
    }
}