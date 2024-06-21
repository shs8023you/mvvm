package com.example.hdi_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.hdi_mvvm.BR
import com.example.hdi_mvvm.R
import com.example.hdi_mvvm.databinding.ActivityCustomDataBindingBinding
import com.example.hdi_mvvm.vm.CustomDataBindingViewModel

class CustomDataBindingActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCustomDataBindingBinding
    private val mViewModel: CustomDataBindingViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivityCustomDataBindingBinding>(
            this,
            R.layout.activity_custom_data_binding
        )
        mBinding.setVariable(BR.vm, mViewModel)

    }
}