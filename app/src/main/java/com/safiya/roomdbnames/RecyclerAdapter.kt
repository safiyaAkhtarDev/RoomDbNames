package com.safiya.roomdbnames


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val userList: ArrayList<UserEntity>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_details, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt_names: TextView = itemView.findViewById(R.id.txt_names)
        fun bindItems(user: UserEntity) {
            txt_names.text = user.name.capitalizeWords()

        }

        fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")

    }

}
