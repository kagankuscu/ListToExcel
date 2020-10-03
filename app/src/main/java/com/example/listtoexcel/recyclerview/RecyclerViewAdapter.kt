package com.example.listtoexcel.recyclerview

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listtoexcel.R
import com.example.listtoexcel.add.WorkDetails
import com.example.listtoexcel.dialog.MyDialog
import kotlinx.android.synthetic.main.list_item_layout.view.*

class RecyclerViewAdapter(var workDetails: ArrayList<WorkDetails>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { v: View ->

                // i will change it. i am going to navigate different page user can see all info about it.
                AlertDialog.Builder(itemView.context)
                    .setTitle(itemView.context.getString(R.string.details))
                    .setMessage(
                        itemView.context.resources.getString(
                            R.string.toast_message,
                            workDetails[adapterPosition].date,
                            workDetails[adapterPosition].dailyJob,
                            workDetails[adapterPosition].workers,
                            workDetails[adapterPosition].price.toString(),
                            workDetails[adapterPosition].totalPrice.toString()

                        )
                    )
                    .setPositiveButton(itemView.context.getString(R.string.btn_ok), DialogInterface.OnClickListener { _, _ ->

                    }).create().show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            tvDate.text = workDetails[position].date
            tvDailyJob.text = workDetails[position].dailyJob
            tvPrice.text = workDetails[position].totalPrice.toString()
        }
    }

    override fun getItemCount(): Int {
        return workDetails.size
    }
}