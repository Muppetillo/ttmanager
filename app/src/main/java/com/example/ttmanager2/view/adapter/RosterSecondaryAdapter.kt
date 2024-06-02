package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.PlayerItemResponse

import com.example.ttmanager2.view.viewHolder.RosterSecondaryViewHolder

class RosterSecondaryAdapter (
    private var playerList: List<PlayerItemResponse> = emptyList(),
) : RecyclerView.Adapter<RosterSecondaryViewHolder>() {
    fun updateList(list: List<PlayerItemResponse>) {
        playerList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterSecondaryViewHolder {
        return RosterSecondaryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_player_secondary, parent, false)
        )
    }

    override fun getItemCount() = playerList.size

    override fun onBindViewHolder(holder: RosterSecondaryViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

}