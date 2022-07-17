package com.example.adapterapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.adapterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        activityMainBinding.diffUtil.setOnClickListener {
            startActivity(Intent(this,DiffUtillActivity::class.java))
        }
        activityMainBinding.singleSelection.setOnClickListener {
            startActivity(Intent(this,SingleSelectionActivity::class.java))
        }
    }
}