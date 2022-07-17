package com.example.adapterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapterapplication.databinding.ActivitySingleSelectionBinding

class SingleSelectionActivity : AppCompatActivity() {
    private lateinit var activitySingleSelectionBinding: ActivitySingleSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySingleSelectionBinding = DataBindingUtil.setContentView(this,R.layout.activity_single_selection)
        activitySingleSelectionBinding.recycleView.layoutManager=LinearLayoutManager(this)
        val adapter=SingleSelectionAdapter(getData())
        activitySingleSelectionBinding.recycleView.adapter=adapter
    }
}