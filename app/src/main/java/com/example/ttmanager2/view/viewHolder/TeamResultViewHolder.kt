package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ItemTeamResultBinding
import com.example.ttmanager2.model.Result

class TeamResultViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemTeamResultBinding.bind(view)

    fun bind (resultResponse: Result){
        binding.tvOtherTeamName.text = resultResponse.team2
        binding.tvOtherTeamFaction.text = resultResponse.team2Faction
        binding.tvResultTeam1.text= resultResponse.team1TD.toString()
        binding.tvCasTeam1.text = resultResponse.team1Cas.toString()
        binding.tvResultTeam2.text =  resultResponse.team2TD.toString()
        binding.tvCasTeam2.text = resultResponse.team2Cas.toString()
        setResult(resultResponse)
        setTeamLogo(resultResponse)
    }

    private fun setResult(resultResponse: Result) {

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
    }

    private fun setTeamLogo(resultResponse: Result) {
        when(resultResponse.team2FactionID){
            "AZ"-> setIcon(R.drawable.amazon)
            "BO"-> setIcon(R.drawable.black_orc)
            "CC"-> setIcon(R.drawable.chaos_chosen)
            "CD"-> setIcon(R.drawable.chaos_dwarf)
            "CR"-> setIcon(R.drawable.chaos_renegade)
            "DE"-> setIcon(R.drawable.dark_elf)
            "DW"-> setIcon(R.drawable.dwarf)
            "EU"-> setIcon(R.drawable.elven_union)
            "GN"-> setIcon(R.drawable.gnome)
            "GO"-> setIcon(R.drawable.goblin)
            "HA"-> setIcon(R.drawable.halfling)
            "HE"-> setIcon(R.drawable.high_elf)
            "HU"-> setIcon(R.drawable.human)
            "IN"-> setIcon(R.drawable.imperial_nobility)
            "KH"-> setIcon(R.drawable.khorne)
            "LI"-> setIcon(R.drawable.lizardmen)
            "NH"-> setIcon(R.drawable.necromantic_horror)
            "NO"-> setIcon(R.drawable.norse)
            "NU"-> setIcon(R.drawable.nurgle)
            "OG"-> setIcon(R.drawable.ogre)
            "OR"-> setIcon(R.drawable.orc)
            "OW"-> setIcon(R.drawable.old_world_alliance)
            "SK"-> setIcon(R.drawable.skaven)
            "SL"-> setIcon(R.drawable.bloodbowl_logo)
            "SN"-> setIcon(R.drawable.snotling)
            "SU"-> setIcon(R.drawable.shambling_undead)
            "TK"-> setIcon(R.drawable.tomb_king)
            "UD"-> setIcon(R.drawable.underworld_denizen)
            "VA"-> setIcon(R.drawable.vampire)
            "WE"-> setIcon(R.drawable.wood_elf)
        }
    }


    private fun setIcon(icon: Int) {
        binding.ivOtherTeamImg.setImageResource(icon)
    }

}