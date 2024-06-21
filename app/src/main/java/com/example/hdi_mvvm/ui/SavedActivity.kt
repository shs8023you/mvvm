package com.example.hdi_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.hdi_mvvm.BR
import com.example.hdi_mvvm.R
import com.example.hdi_mvvm.databinding.ActivityDataBindingBinding
import com.example.hdi_mvvm.databinding.ActivitySavedBinding
import com.example.hdi_mvvm.databinding.ActivityXmlMainBinding
import com.example.hdi_mvvm.vm.SavedStateViewModel

class SavedActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySavedBinding

    private val mViewModel: SavedStateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<ActivitySavedBinding>(
            this,
            R.layout.activity_saved
        )
        // 给vm变量赋值  需要引入kotlin-kapt 才可以生成BR文件
        mBinding.setVariable(BR.vm, mViewModel)
    }
}