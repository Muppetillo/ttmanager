package com.example.ttmanager2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemFactionBinding
import com.example.ttmanager2.databinding.ItemTeamBinding
import com.example.ttmanager2.model.FactionItemResponse
import com.example.ttmanager2.model.TeamItemResponse

class TeamViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemTeamBinding.bind(view)

    fun bind (teamItem : TeamItemResponse, navigateToTeamActivity: (String)-> Unit){
        val record = "${teamItem.wins}W - ${teamItem.draws}D - ${teamItem.losses}L"

        binding.tvMyTeamName.text = teamItem.name
        binding.tvMyTeamValue.text = teamItem.teamValue.toString()
        binding.tvMyTeamFaction.text = teamItem.faction
        binding.TVMyTeamRecord.text = record

        binding.root.setOnClickListener{
            navigateToTeamActivity(teamItem.id.toString())
        }
    }



}
