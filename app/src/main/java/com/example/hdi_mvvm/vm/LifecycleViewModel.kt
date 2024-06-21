package com.example.hdi_mvvm.vm

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


/**
 * 监听View的生命周期
 * DefaultLifecycleObserver 是一个接口, 所以可以绑定任何类,不一定是ViewModel
 */
class LifecycleViewModel : ViewModel(), DefaultLifecycleObserver {


    val text = MutableLiveData<String>("")

    init {
        Log.d("LifecycleViewModel", "init")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("LifecycleViewModel", "onResume")
        text.value = "onResume "

    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("LifecycleViewModel", "onPause")
        text.value = "onPause "
    }

}