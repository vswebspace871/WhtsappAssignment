package com.example.whtsappassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whtsappassignment.databinding.RvItemBinding

class ChatAdapter(val userList: ArrayList<User>) :
    RecyclerView.Adapter<ChatAdapter.PopularViewHolder>() {
    lateinit var onClick: ((User) -> Unit)
    //private var userList = ArrayList<User>()

    inner class PopularViewHolder(val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.binding.username.text = userList[position].name
        holder.binding.userImage.setImageResource(userList[position].image)

        holder.itemView.setOnClickListener {
            onClick.invoke(userList[position])
        }
    }
}