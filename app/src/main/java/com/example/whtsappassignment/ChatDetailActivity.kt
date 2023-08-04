package com.example.whtsappassignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whtsappassignment.databinding.ActivityChatDetailBinding

class ChatDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityChatDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /** creating raw data*/
        val mydataList = ArrayList<ChatModel>()
        mydataList.add(ChatModel(ChatDetailAdapter.THE_FIRST_VIEW, "Hello Sir"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_SECOND_VIEW, "Hello, Who is this"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_FIRST_VIEW, "Sir, I am an android developer"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_SECOND_VIEW, "Ok, What Projects have you developed"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_FIRST_VIEW, "Sir i have mailed you"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_SECOND_VIEW, "ok, We will get back to you soon"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_FIRST_VIEW, "Thank you sir for your time"))
        mydataList.add(ChatModel(ChatDetailAdapter.THE_SECOND_VIEW, "Your Welcome"))
        /** initialising adapter */
        val cadapter = ChatDetailAdapter(mydataList, this)

        /** setting up the recyclerview */
        setUpTheRecyclerview(cadapter)

        binding.imageView.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, 101)
        }
    }

    private fun setUpTheRecyclerview(cadapter: ChatDetailAdapter) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ChatDetailActivity)
            adapter = cadapter
        }
    }
}