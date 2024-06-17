package com.example.hdi_mvvm.vm

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


/**
 * 可以保存 状态的ViewModel 比如内存不足页面被杀掉时
 */
class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {


    val imageUrl = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"

    var userName = MutableLiveData<String>("")

    var pwd = MutableLiveData<String>("")

    /**
     *   测试的数据源
     */
    private val data = savedStateHandle.getLiveData<String>(DATA_SAVE_KEY)

    init {
        // 恢复数据 如果有的话
        if (savedStateHandle.contains(DATA_SAVE_KEY)) {
            data.value = savedStateHandle[DATA_SAVE_KEY]
        }
    }

    fun onLogin(view: View) {
        saveData()

        Toast.makeText(
            view.context, "存储的信息 ${data.value}", Toast
                .LENGTH_SHORT
        ).show()
    }

    /**
     * 保存数据,
     */
    private fun saveData() {
        savedStateHandle["query"] = "${userName.value} ${pwd.value}"
        data.value = "${userName.value} ${pwd.value}"
    }

    private suspend fun login(): Boolean {
        withContext(Dispatchers.IO) {
            delay(1000)
        }
        // 随机返回登录结果
        return Math.random() < 0.5
    }

    companion object {
        private const val DATA_SAVE_KEY = "save_key"
    }

}