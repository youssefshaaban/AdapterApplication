package com.example.adapterapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.adapterapplication.databinding.ItemLayoutTestBinding

class DiffUtilAdapterList() :
    ListAdapter<Model, DiffUtilAdapterList.MyViewHolder>(DifItem()) {

    class MyViewHolder(val binding: ItemLayoutTestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Model) {
            binding.item=item
        }

    }

    class DifItem : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean =
            oldItem == newItem


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_layout_test,parent,false))

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(holder.adapterPosition))
        Log.e("pos", holder.adapterPosition.toString())
    }
}