package com.example.whtsappassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent

class ChatDetailAdapter(val list : ArrayList<ChatModel>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val THE_FIRST_VIEW = 1
        const val THE_SECOND_VIEW = 2
    }

    private inner class ViewOne(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tv: TextView = itemView.findViewById(R.id.tv_sm)
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
            tv.text = recyclerViewModel.message
        }
    }

    private inner class ViewTwo(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tv: TextView = itemView.findViewById(R.id.tv_rm)
        fun bind(position: Int) {
            val recyclerViewModel = list[position]
            tv.text = recyclerViewModel.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == THE_FIRST_VIEW) {
            return ViewOne(
                LayoutInflater.from(context).inflate(R.layout.sender_message_layout, parent, false)
            )
        }
        return ViewTwo(
            LayoutInflater.from(context).inflate(R.layout.receiver_message_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].viewType === THE_FIRST_VIEW) {
            (holder as ViewOne).bind(position)
        } else {
            (holder as ViewTwo).bind(position)
        }
    }
}