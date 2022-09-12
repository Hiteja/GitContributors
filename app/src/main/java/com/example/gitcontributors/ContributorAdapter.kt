package com.example.gitcontributors

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContributorAdapter(private val contributorList:List<ContributorItem>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = contributorList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return contributorList.size
    }
}

class MyViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView){
    fun bind(item:ContributorItem){
        Log.i("MyTag", "Adapter view holder")
        val userName = itemView.findViewById<TextView>(R.id.tvUserName)
        val userImage = itemView.findViewById<ImageView>(R.id.ivUserImage)
        userName.text = item.userName
    }
}

