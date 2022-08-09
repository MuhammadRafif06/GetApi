package com.rafif.latihangetapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafif.latihangetapi.data.UserResponseItem
import com.rafif.latihangetapi.databinding.ItemUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val listUser = ArrayList<UserResponseItem>()

    class UserViewHolder(val itemUser: ItemUserBinding) :
        RecyclerView.ViewHolder(itemUser.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemUser.apply {
            with(listUser[position]){
                tvName.text = name
                tvId.text = username
                tvEmail.text = email
            }
        }
    }

    override fun getItemCount() = listUser.size

    fun setUser(users: ArrayList<UserResponseItem>){
        this.listUser.clear()
        this.listUser.addAll(users)
    }
}