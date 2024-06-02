package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.Match
import com.example.ttmanager2.view.viewHolder.TeamMatchViewHolder

class TeamMatchAdapter(
    private var matchList: List<Match> = emptyList()
) :  RecyclerView.Adapter<TeamMatchViewHolder>() {

    fun updateList(list: List<Match>) {
        matchList = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMatchViewHolder {
        return TeamMatchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_team_match, parent, false)
        )
    }

    override fun getItemCount() = matchList.size

    override fun onBindViewHolder(holder: TeamMatchViewHolder, position: Int) {
        holder.bind(matchList[position])
    }
}