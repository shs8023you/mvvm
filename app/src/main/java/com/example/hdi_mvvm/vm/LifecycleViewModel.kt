package com.example.hdi_mvvm.vm

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * 监听View的生命周期
 * DefaultLifecycleObserver 是一个接口, 所以可以绑定任何类,不一定是ViewModel
 */
class LifecycleViewModel : ViewModel(), DefaultLifecycleObserver {


    // 什么是 粘性事件？
    // 即发射的事件如果早于注册，那么注册之后依然可以接收到的事件称为粘性事件
    var text = MutableLiveData("默认值")

    init {
        Log.d("LifecycleViewModel", "init")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("LifecycleViewModel", "onResume")
        text.value = "onResume"

    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("LifecycleViewModel", "onPause")
        text.value = "onPause"
    }

}