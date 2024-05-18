package com.example.ttmanager2.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemFactionBinding
import com.example.ttmanager2.model.FactionItemResponse

class FactionViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemFactionBinding.bind(view)

    fun bind (factionItem : FactionItemResponse, showFactionInfo: (FactionItemResponse)-> Unit){
        binding.tvFactionName.text = factionItem.name
        binding.root.setOnClickListener{
            showFactionInfo(factionItem)
        }
    }

}