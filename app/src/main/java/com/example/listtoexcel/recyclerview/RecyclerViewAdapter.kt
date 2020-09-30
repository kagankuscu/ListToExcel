package com.example.listtoexcel.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listtoexcel.R
import com.example.listtoexcel.add.WorkDetails
import kotlinx.android.synthetic.main.list_item_layout.view.*

class RecyclerViewAdapter(var workDetails: ArrayList<WorkDetails>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tvDate.text = workDetails[position].date
            tvDailyJob.text = workDetails[position].dailyJob
            tvPrice.text = workDetails[position].price.toString()
        }
    }

    override fun getItemCount(): Int {
        return workDetails.size
    }
}