package com.example.ttmanager2.view.viewHolder

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.databinding.ItemEventBinding
import com.example.ttmanager2.model.League

class EventViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemEventBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(eventResponse: League, navigateToLeagueActivity: (String)-> Unit){
        binding.tvEventName.text = eventResponse.name
        binding.tvEventPlace.text = "${eventResponse.city}, ${eventResponse.country}"
        binding.root.setOnClickListener{
            //navigateToLeagueActivity(eventResponse.ID.toString())
        }
    }


}
