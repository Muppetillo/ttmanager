package com.example.ttmanager2.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ttmanager2.R
import com.example.ttmanager2.model.Result
import com.example.ttmanager2.view.viewHolder.ResultViewHolder

class ResultAdapter  (
    private var resultList: List<Result> = emptyList(),
    private val navigateToMatchActivity: (String) -> Unit
) : RecyclerView.Adapter<ResultViewHolder>() {

    fun updateList(list: List<Result>) {
        resultList = list
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_latest_results, parent, false)
        )
    }

    override fun getItemCount() = resultList.size

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.bind(resultList[position],navigateToMatchActivity)
    }

}

