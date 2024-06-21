package com.example.hdi_mvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hdi_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        mBinding.lifeCycle.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }

        mBinding.singleBinding.setOnClickListener {
            val intent = Intent(this, XmlMainActivity::class.java)
            startActivity(intent)
        }
        mBinding.dateBinding.setOnClickListener {
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        }
        mBinding.dateBinding.setOnClickListener {
            val intent = Intent(this, CustomDataBindingActivity::class.java)
            startActivity(intent)
        }
        mBinding.saved.setOnClickListener {
            val intent = Intent(this, SavedActivity::class.java)
            startActivity(intent)
        }


    }
}