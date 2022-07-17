package com.example.adapterapplication

import android.util.Log
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.adapterapplication.databinding.ItemLayoutTestBinding

class SingleSelectionAdapter(private val list: List<Model>) :
    RecyclerView.Adapter<SingleSelectionAdapter.MyViewHolder>() {
    private var checkedPosition = -1

    class MyViewHolder(val binding: ItemLayoutTestBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Model, chekPosition: Int) {
            item.isSelected = layoutPosition == chekPosition
            binding.item=item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_layout_test,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(item = list[position], checkedPosition)
        holder.binding.radio.setOnClickListener {
            notifyItemChanged(checkedPosition)
            checkedPosition = holder.adapterPosition
            notifyItemChanged(checkedPosition)
        }
        Log.e("pos", holder.adapterPosition.toString())
    }

    override fun getItemCount(): Int {
        return list.size
    }

}