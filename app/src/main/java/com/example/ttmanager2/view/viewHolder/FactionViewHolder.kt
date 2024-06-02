package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ItemFactionBinding
import com.example.ttmanager2.model.FactionItemResponse

class FactionViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemFactionBinding.bind(view)

    fun bind (factionItem : FactionItemResponse, showFactionInfo: (FactionItemResponse)-> Unit){
        binding.tvFactionName.text = factionItem.name
        when(factionItem.id){
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
        binding.root.setOnClickListener{
            showFactionInfo(factionItem)
        }
    }

    fun setIcon(icon: Int) {
        binding.ivFactionIcon.setImageResource(icon)
    }

}