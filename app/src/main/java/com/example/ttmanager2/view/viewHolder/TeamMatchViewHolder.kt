package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ItemNextMatchBinding
import com.example.ttmanager2.databinding.ItemTeamBinding
import com.example.ttmanager2.databinding.ItemTeamMatchBinding
import com.example.ttmanager2.model.Match
import com.example.ttmanager2.model.Result
import com.example.ttmanager2.model.TeamItemResponse

class TeamMatchViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemTeamMatchBinding.bind(view)

    fun bind(matchResponse: Match) {
        binding.tvOtherTeamName.text = matchResponse.team2
        binding.tvOtherTeamFaction.text = matchResponse.team2Faction
        binding.tvTeamRound.text = matchResponse.round
        binding.tvTeamEventName.text = matchResponse.league
        setOtherTeamLogo(matchResponse)
    }

    private fun setOtherTeamLogo(matchResponse: Match) {
        when (matchResponse.team2FactionID) {
            "AZ" -> setIcon(R.drawable.amazon)
            "BO" -> setIcon(R.drawable.black_orc)
            "CC" -> setIcon(R.drawable.chaos_chosen)
            "CD" -> setIcon(R.drawable.chaos_dwarf)
            "CR" -> setIcon(R.drawable.chaos_renegade)
            "DE" -> setIcon(R.drawable.dark_elf)
            "DW" -> setIcon(R.drawable.dwarf)
            "EU" -> setIcon(R.drawable.elven_union)
            "GN" -> setIcon(R.drawable.gnome)
            "GO" -> setIcon(R.drawable.goblin)
            "HA" -> setIcon(R.drawable.halfling)
            "HE" -> setIcon(R.drawable.high_elf)
            "HU" -> setIcon(R.drawable.human)
            "IN" -> setIcon(R.drawable.imperial_nobility)
            "KH" -> setIcon(R.drawable.khorne)
            "LI" -> setIcon(R.drawable.lizardmen)
            "NH" -> setIcon(R.drawable.necromantic_horror)
            "NO" -> setIcon(R.drawable.norse)
            "NU" -> setIcon(R.drawable.nurgle)
            "OG" -> setIcon(R.drawable.ogre)
            "OR" -> setIcon(R.drawable.orc)
            "OW" -> setIcon(R.drawable.old_world_alliance)
            "SK" -> setIcon(R.drawable.skaven)
            "SL" -> setIcon(R.drawable.bloodbowl_logo)
            "SN" -> setIcon(R.drawable.snotling)
            "SU" -> setIcon(R.drawable.shambling_undead)
            "TK" -> setIcon(R.drawable.tomb_king)
            "UD" -> setIcon(R.drawable.underworld_denizen)
            "VA" -> setIcon(R.drawable.vampire)
            "WE" -> setIcon(R.drawable.wood_elf)
        }

    }

    private fun setIcon(icon: Int) {
        binding.ivOtherTeamImg.setImageResource(icon)
    }
}