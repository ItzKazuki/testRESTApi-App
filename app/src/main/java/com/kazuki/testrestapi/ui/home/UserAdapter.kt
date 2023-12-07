package com.kazuki.testrestapi.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kazuki.testrestapi.databinding.ItemUserBinding
import com.kazuki.testrestapi.model.User

class UserAdapter: RecyclerView.Adapter<UserViewHolder>() {
    private var users = arrayListOf<User>()
    // create viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userViewBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UserViewHolder(userViewBinding)
    }

    // get list array
    override fun getItemCount(): Int {
        return users.size
    }

    // untuk mengkoneksikan data per index degan layout item di XML
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    //untuk input data dari luar ke dalam class adapter
    fun inputDataToAdapter(data: ArrayList<User>) {
        if(data.isNotEmpty()) {
            users = data
            notifyDataSetChanged()
        }
    }
}