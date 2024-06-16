package com.example.hdi_mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.hdi_mvvm.databinding.ActivityDataBindingBinding
import com.example.hdi_mvvm.vm.DataBindingViewModel

class DataBindingActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityDataBindingBinding
    private val mViewModel: DataBindingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 这是传统写法
        // setContentView(R.layout.activity_data_binding)

        // 这是DataBinding 双向绑定写法
        // 泛型是自动生成的 规则是 : 布局文件+Binding
        mBinding = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this,R.layout.activity_data_binding)
        // 给vm变量赋值  需要引入kotlin-kapt 才可以生成BR文件
        mBinding.setVariable(BR.vm,mViewModel)
    }
}