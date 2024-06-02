package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.PositionalItemResponse
import com.example.ttmanager2.view.viewHolder.PositionalMainViewHolder
import com.example.ttmanager2.view.viewHolder.PositionalSecondaryViewHolder

class PositionalSecondaryAdapter (
    private var positionalList: List<PositionalItemResponse> = emptyList(),
) : RecyclerView.Adapter<PositionalSecondaryViewHolder>() {
    fun updateList(list: List<PositionalItemResponse>) {
        positionalList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionalSecondaryViewHolder {
        return PositionalSecondaryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_positional_secondary, parent, false)
        )
    }

    override fun getItemCount() = positionalList.size

    override fun onBindViewHolder(holder: PositionalSecondaryViewHolder, position: Int) {
        holder.bind(positionalList[position])
    }

}