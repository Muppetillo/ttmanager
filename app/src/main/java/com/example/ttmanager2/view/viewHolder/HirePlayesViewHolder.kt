package com.example.ttmanager2.view.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemBuyPlayerBinding
import com.example.ttmanager2.model.PositionalItemResponse

class HirePlayesViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemBuyPlayerBinding.bind(view)

    fun bind (positionalItem : PositionalItemResponse,updateRoster: (PositionalItemResponse)-> Unit){
        binding.tvPositionalName.text = positionalItem.name
        binding.tvPositionalQty.text = "0-${positionalItem.maxQty}"
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
        binding.btnAddPositional.setOnClickListener {
            updateRoster(positionalItem)
        }
    }



}

