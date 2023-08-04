package com.example.whtsappassignment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whtsappassignment.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    lateinit var userList: ArrayList<User>
    lateinit var chatadapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userList = ArrayList()
        userList.add(User(1, "Raj Sharma", R.drawable.pic1))
        userList.add(User(2, "Manoj Verma", R.drawable.pic2))
        userList.add(User(3, "Pinki Kumari", R.drawable.pic3))
        chatadapter = ChatAdapter(userList)

        binding.userListRecyclerview.apply {
            adapter = chatadapter
        }

        chatadapter.onClick = {
            context?.startActivity(Intent(requireContext(), ChatDetailActivity::class.java))
        }
    }
}