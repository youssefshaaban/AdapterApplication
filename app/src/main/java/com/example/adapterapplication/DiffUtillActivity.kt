package com.example.adapterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapterapplication.databinding.ActivityDiffUtilBinding

class DiffUtillActivity : AppCompatActivity() {
    lateinit var activityDiffUtilBinding: ActivityDiffUtilBinding
    lateinit var adapterList: DiffUtilAdapterList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDiffUtilBinding= DataBindingUtil.setContentView(this,R.layout.activity_diff_util)
        activityDiffUtilBinding.recycleView.layoutManager=LinearLayoutManager(this)
        adapterList=DiffUtilAdapterList()
        activityDiffUtilBinding.recycleView.adapter=adapterList
        adapterList.submitList(getData(10))
        activityDiffUtilBinding.addBtn.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        val item=Model(adapterList.itemCount,"title ${adapterList.itemCount}")
        val list = adapterList.currentList.toMutableList()
        list.add(item)
        adapterList.submitList(list)
    }
}