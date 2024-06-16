package com.example.hdi_mvvm.vm

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep


/**
 * 可以双向绑定
 */
class DataBindingViewModel : ViewModel() {
    val imageUrl = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"

    var userName = MutableLiveData<String>("")

    var pwd = MutableLiveData<String>("")


    fun onLogin(view: View) {
        viewModelScope.launch {
            // 登录..
            val result = login()

            // 登录失败
            if(!result){
                Toast.makeText(view.context, "登录失败", Toast.LENGTH_LONG).show()
                return@launch
            }
            // 登录成功
            Toast.makeText(view.context, "登录成功 userName:${userName.value} pwd${pwd.value}", Toast.LENGTH_LONG).show()
        }
    }

    private suspend fun login():Boolean{
        withContext(Dispatchers.IO){
            delay(1000)
        }
        // 随机返回登录结果
        return Math.random() < 0.5
    }

}