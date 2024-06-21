package com.example.hdi_mvvm.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hdi_mvvm.R
import com.example.hdi_mvvm.vm.LifecycleViewModel

class LifeCycleActivity : AppCompatActivity() {

    private val mViewModel: LifecycleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        lifecycle.addObserver(mViewModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mViewModel)
    }

}