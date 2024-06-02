package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemFactionBinding
import com.example.ttmanager2.databinding.ItemPositionalMainBinding
import com.example.ttmanager2.model.FactionItemResponse
import com.example.ttmanager2.model.PositionalItemResponse

class PositionalMainViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPositionalMainBinding.bind(view)

    fun bind (positionalItem : PositionalItemResponse){
            binding.tvPositionalName.text = positionalItem.name
            binding.tvPositionalQty.text = "0-${positionalItem.maxQty}"
        }
    }

