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
 * 可以保存 状态的ViewModel 比如内存不足页面被回收时
 *
 * 这种并不属于屏幕旋转,所以ViewModel会重建, 输入框的内容会丢失
 */
class SavedStateViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {


    var userName = MutableLiveData<String>("")

    var pwd = MutableLiveData<String>("")

    /**
     *   测试的数据源
     */
    val data = savedStateHandle.getLiveData<String>(DATA_SAVE_KEY)

    init {
        // 恢复数据 如果有的话
        if (savedStateHandle.contains(DATA_SAVE_KEY)) {
            data.value = savedStateHandle[DATA_SAVE_KEY]
        }

    }

    fun onLogin(view: View) {
        // 点击登录时保存
        saveData()

        Toast.makeText(
            view.context, "已保存 ${data.value}", Toast
                .LENGTH_SHORT
        ).show()
    }


    /**
     * 保存数据
     */
    private fun saveData() {
        savedStateHandle[DATA_SAVE_KEY] = "${userName.value} ${pwd.value}"
    }


    companion object {
        private const val DATA_SAVE_KEY = "save_key"
    }

}