package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.FactionItemResponse
import com.example.ttmanager2.model.PositionalItemResponse
import com.example.ttmanager2.view.viewHolder.PositionalMainViewHolder


class PositionalMainAdapter(
    private var positionalList: List<PositionalItemResponse> = emptyList(),
) : RecyclerView.Adapter<PositionalMainViewHolder>() {
    fun updateList(list: List<PositionalItemResponse>) {
        positionalList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionalMainViewHolder {
        return PositionalMainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_positional_main, parent, false)
        )
    }

    override fun getItemCount() = positionalList.size

    override fun onBindViewHolder(holder: PositionalMainViewHolder, position: Int) {
        holder.bind(positionalList[position])
    }

}