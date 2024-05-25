package com.example.ttmanager2.viewHolder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemNextMatchBinding
import com.example.ttmanager2.model.Match

class MatchViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemNextMatchBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(matchResponse: Match, navigateToLeagueActivity: (String)-> Unit){
        binding.tvNameTeam1.text = matchResponse.team1.toString()
        binding.tvNameTeam2.text = matchResponse.team2.toString()
        binding.tvFactionTeam1.text = matchResponse.t
        binding.root.setOnClickListener{
            navigateToMatchActivity(matchResponse.ID.toString())
        }
    }


}
