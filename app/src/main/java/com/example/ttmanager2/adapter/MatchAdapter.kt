package com.example.ttmanager2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.League
import com.example.ttmanager2.model.Match
import com.example.ttmanager2.model.TeamItemResponse
import com.example.ttmanager2.viewHolder.EventViewHolder
import com.example.ttmanager2.viewHolder.FactionViewHolder
import com.example.ttmanager2.viewHolder.MatchViewHolder
import com.example.ttmanager2.viewHolder.TeamViewHolder

class MatchAdapter (
    private var matchList: List<Match> = emptyList(),
    private val navigateToMatchActivity: (String) -> Unit
) :
    RecyclerView.Adapter<MatchViewHolder>() {

    fun updateList(list: List<Match>) {
        matchList = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        )
    }

    override fun getItemCount() = matchList.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matchList[position],navigateToMatchActivity)
    }


}