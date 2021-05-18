package com.example.airtracking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RVAdapter(
    private val exampleList: List<AirlineItem>,
    private val listener: OnItemClickListener
    ):
    RecyclerView.Adapter<RVAdapter.RVViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.airline_card,
            parent,
            false
        )
        return RVViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.iv_airline_icon.setImageResource(currentItem.iv_airline_icon)
        holder.tv_airline_name.text = currentItem.tv_airline_name

    }

    override fun getItemCount() = exampleList.size

    inner class RVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val iv_airline_icon: ImageView = itemView.findViewById(R.id.iv_airline_icon)
        val tv_airline_name: TextView = itemView.findViewById(R.id.tv_airline_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }

        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


}