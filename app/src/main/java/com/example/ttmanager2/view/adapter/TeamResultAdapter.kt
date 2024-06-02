package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.Result
import com.example.ttmanager2.view.viewHolder.TeamResultViewHolder

class TeamResultAdapter (
    private var resultList: List<Result> = emptyList(),
) :
    RecyclerView.Adapter<TeamResultViewHolder>() {

    fun updateList(list: List<Result>) {
        resultList = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamResultViewHolder {
        return TeamResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_team_result, parent, false)
        )
    }

    override fun getItemCount() = resultList.size

    override fun onBindViewHolder(holder: TeamResultViewHolder, position: Int) {
        holder.bind(resultList[position])
    }
}