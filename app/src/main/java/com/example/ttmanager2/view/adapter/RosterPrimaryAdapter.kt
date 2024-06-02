package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.PlayerItemResponse
import com.example.ttmanager2.view.viewHolder.PositionalMainViewHolder
import com.example.ttmanager2.view.viewHolder.RosterPrimaryViewHolder

class RosterPrimaryAdapter(
    private var playerList: List<PlayerItemResponse> = emptyList(),
) : RecyclerView.Adapter<RosterPrimaryViewHolder>() {
    fun updateList(list: List<PlayerItemResponse>) {
        playerList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterPrimaryViewHolder {
        return RosterPrimaryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_player_main, parent, false)
        )
    }

    override fun getItemCount() = playerList.size

    override fun onBindViewHolder(holder: RosterPrimaryViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

}