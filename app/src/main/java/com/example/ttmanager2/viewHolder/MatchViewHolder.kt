package com.example.ttmanager2.viewHolder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ItemNextMatchBinding
import com.example.ttmanager2.model.Match

class MatchViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemNextMatchBinding.bind(view)

    fun bind(matchResponse: Match, navigateToMatchActivity: (String)-> Unit){
        binding.tvNameTeam1.text = matchResponse.team1
        binding.tvNameTeam2.text = matchResponse.team2
        binding.tvFactionTeam1.text = matchResponse.team1Faction
        binding.tvFactionTeam2.text = matchResponse.team2Faction
        binding.tvMatchPlace.text = matchResponse.place
        binding.tvMatchSchedule.text = matchResponse.schedule
        binding.ivIconTeam1.setImageResource(R.drawable.dark_elf)
        binding.ivIconTeam2.setImageResource(R.drawable.bblogoicon2018_web)
        binding.root.setOnClickListener{
            navigateToMatchActivity(matchResponse.ID.toString())
        }
    }


}
