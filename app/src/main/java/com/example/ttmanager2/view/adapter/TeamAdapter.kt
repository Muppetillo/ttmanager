package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.TeamItemResponse
import com.example.ttmanager2.view.viewHolder.FactionViewHolder
import com.example.ttmanager2.view.viewHolder.TeamViewHolder

class TeamAdapter (
    private var teamList: List<TeamItemResponse> = emptyList(),
    private val navigateToTeamActivity: (String) -> Unit
): RecyclerView.Adapter<TeamViewHolder>() {
    fun updateList(list: List<TeamItemResponse>) {
        teamList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_team,parent,false)
        )
    }

    override fun getItemCount() = teamList.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamList[position],navigateToTeamActivity)
    }

}