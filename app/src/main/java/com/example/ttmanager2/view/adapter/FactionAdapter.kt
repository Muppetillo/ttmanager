package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.FactionItemResponse
import com.example.ttmanager2.view.viewHolder.FactionViewHolder

class FactionAdapter (
    private var factionList: List<FactionItemResponse> = emptyList(),
    private val showFactionInfo: (FactionItemResponse) -> Unit
): RecyclerView.Adapter<FactionViewHolder>() {
    fun updateList(list: List<FactionItemResponse>) {
        factionList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactionViewHolder {
        return FactionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_faction,parent,false)
        )
    }

    override fun getItemCount() = factionList.size

    override fun onBindViewHolder(holder: FactionViewHolder, position: Int) {
        holder.bind(factionList[position],showFactionInfo)
    }

}