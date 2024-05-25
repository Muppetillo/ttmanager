package com.example.ttmanager2.viewHolderw

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ItemLatestResultsBinding
import com.example.ttmanager2.model.Match
import com.example.ttmanager2.model.Result

class ResultViewHolder  (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemLatestResultsBinding.bind(view)

    fun bind(resultResponse: Result, navigateToMatchActivity: (String)-> Unit){
        binding.tvNameTeam1.text = resultResponse.team1
        binding.tvFactionTeam1.text = resultResponse.team1Faction
        binding.tvTDTeam1.text = resultResponse.team1TD.toString()
        binding.ivIconTeam1.setImageResource(R.drawable.dark_elf)

        binding.tvNameTeam2.text = resultResponse.team2
        binding.tvFactionTeam2.text = resultResponse.team2Faction
        binding.tvTDTeam2.text = resultResponse.team2TD.toString()
        binding.ivIconTeam2.setImageResource(R.drawable.bblogoicon2018_web)

        binding.tvMatchLeague.text = resultResponse.league
        binding.tvMatchRound.text = resultResponse.round
        if(resultResponse.team1TD > resultResponse.team2TD) {
            binding.tvMyResult.text = "Win"
            binding.ivMyResult.setImageResource(R.drawable.circlewin_shape)
        } else if (resultResponse.team1TD == resultResponse.team2TD) {
            binding.tvMyResult.text = "Draw"
            binding.ivMyResult.setImageResource(R.drawable.circledraw_shape)
        } else {
            binding.tvMyResult.text = "Loss"
            binding.ivMyResult.setImageResource(R.drawable.circleloss_shape)
        }

        binding.root.setOnClickListener{
            navigateToMatchActivity(resultResponse.ID.toString())
        }
    }


}