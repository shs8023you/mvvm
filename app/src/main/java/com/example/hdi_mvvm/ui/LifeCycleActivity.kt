package com.example.hdi_mvvm.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hdi_mvvm.R
import com.example.hdi_mvvm.databinding.ActivityLifeCycleBinding
import com.example.hdi_mvvm.vm.LifecycleViewModel

class LifeCycleActivity : AppCompatActivity() {

    private val mBinding: ActivityLifeCycleBinding by lazy {
        ActivityLifeCycleBinding.inflate(layoutInflater)
    }

    private val mViewModel: LifecycleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        lifecycle.addObserver(mViewModel)

        mViewModel.text.observe(this) {
            Toast.makeText(this, "生命周期 $it", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(mViewModel)
    }

}