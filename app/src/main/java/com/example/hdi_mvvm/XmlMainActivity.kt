package com.example.hdi_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.example.hdi_mvvm.databinding.ActivityXmlMainBinding
import com.example.hdi_mvvm.vm.XmlViewModel

class XmlMainActivity : ComponentActivity() {
    private val mBinding: ActivityXmlMainBinding by lazy {
        ActivityXmlMainBinding.inflate(layoutInflater)
    }

    val viewModel: XmlViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initViews()
    }


    private fun initViews() {

        // 单项绑定 : 监听值的变化
        viewModel.title.observe(this) { title ->
            mBinding.titleView.text = title
        }
    }
}