package com.example.ttmanager2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.League
import com.example.ttmanager2.viewHolder.EventViewHolder

class EventAdapter(
    private var leaguesList: List<League> = emptyList(),
    private val navigateToLeagueActivity: (String) -> Unit
) :
    RecyclerView.Adapter<EventViewHolder>() {

    fun updateList(list: List<League>) {
        leaguesList = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        )
    }

    override fun getItemCount() = leaguesList.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(leaguesList[position],navigateToLeagueActivity)
    }


}