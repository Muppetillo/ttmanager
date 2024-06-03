package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.databinding.ItemPlayerSecondaryBinding
import com.example.ttmanager2.model.PlayerItemResponse


class RosterSecondaryViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPlayerSecondaryBinding.bind(view)

    fun bind (playerItem: PlayerItemResponse){
        binding.tvPlayerMA.text = playerItem.ma.toString()
        binding.tvPlayerST.text = playerItem.st.toString()
        binding.tvPlayerAG.text = playerItem.ag.toString()+"+"
        if(playerItem.pa > 0){
            binding.tvPlayerPA.text = playerItem.pa.toString()+"+"
        } else {
            binding.tvPlayerPA.text = "-"
        }
        if(playerItem.mng == true){
            binding.ivPlayerMNG.setImageResource(R.drawable.icn_check)
        }
        binding.tvPlayerSPP.text = playerItem.spp.toString()
        binding.tvPlayerAV.text = playerItem.av.toString()+"+"
        binding.tvPlayerSkills.text = playerItem.skills
        binding.tvPlayerTD.text = playerItem.td.toString()
        binding.tvPlayerCAS.text = playerItem.cas.toString()
        binding.tvPlayerINT.text = playerItem.int.toString()
        binding.tvPlayerCOM.text = playerItem.com.toString()
        binding.tvPlayerMVP.text = playerItem.mvp.toString()
        binding.tvPlayerValue.text = playerItem.value.toString()+"k"

    }
}