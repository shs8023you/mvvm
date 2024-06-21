package com.example.hdi_mvvm.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.example.hdi_mvvm.databinding.ActivityXmlMainBinding
import com.example.hdi_mvvm.vm.XmlViewModel

class XmlMainActivity : ComponentActivity() {
    private val mBinding: ActivityXmlMainBinding by lazy {
        ActivityXmlMainBinding.inflate(layoutInflater)
    }

    private val mViewModel: XmlViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initViews()
    }

    private fun initViews() {

        // 单项绑定 : 监听值的变化
        // 输入框 内容变化时 通知ViewModel
        mBinding.username.addTextChangedListener {
            mViewModel.userName.value = it.toString()
        }

        // 输入框 内容变化时 通知ViewModel
        mBinding.password.addTextChangedListener {
            mViewModel.pwd.value = it.toString()
        }

        // 点击登录
        mBinding.loginButton.setOnClickListener {
            mViewModel.onLogin(it)
        }


    }
}