package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.PositionalItemResponse
import com.example.ttmanager2.view.viewHolder.HirePlayesViewHolder


class HirePlayersAdapter(
    private var positionalList: List<PositionalItemResponse> = emptyList(),
    private val updateRoster: (PositionalItemResponse) -> Unit
) : RecyclerView.Adapter<HirePlayesViewHolder>() {
    fun updateList(list: List<PositionalItemResponse>) {
        positionalList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HirePlayesViewHolder {
        return HirePlayesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_buy_player, parent, false)
        )
    }

    override fun getItemCount() = positionalList.size

    override fun onBindViewHolder(holder: HirePlayesViewHolder, position: Int) {
        holder.bind(positionalList[position],updateRoster)
    }

}