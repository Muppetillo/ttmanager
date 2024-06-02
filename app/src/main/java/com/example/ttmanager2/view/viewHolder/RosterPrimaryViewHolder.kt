package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemPlayerMainBinding
import com.example.ttmanager2.model.PlayerItemResponse

import com.example.ttmanager2.model.PositionalItemResponse

class RosterPrimaryViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPlayerMainBinding.bind(view)

    fun bind (playerItem : PlayerItemResponse){
        binding.tvPlayerName.text = "${playerItem.name}"
        binding.tvPlayerPosition.text = "${playerItem.positional}"
        binding.tvPlayerNumber.text = "${playerItem.number}"
    }
}

