package com.example.ttmanager2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemPositionalSecondaryBinding
import com.example.ttmanager2.model.PositionalItemResponse

class PositionalSecondaryViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPositionalSecondaryBinding.bind(view)

    fun bind (positionalItem : PositionalItemResponse){
        binding.tvPositionalMA.text = positionalItem.ma.toString()
        binding.tvPositionalST.text = positionalItem.st.toString()
        binding.tvPositionalAG.text = positionalItem.ag.toString()+"+"
        if(positionalItem.pa > 0){
            binding.tvPositionalPA.text = positionalItem.pa.toString()+"+"
        } else {
            binding.tvPositionalPA.text = "-"
        }

        binding.tvPositionalAV.text = positionalItem.av.toString()+"+"
        binding.tvPositionalSkills.text = positionalItem.skills
        binding.tvPositionalValue.text = positionalItem.price.toString()+"k"
    }
}