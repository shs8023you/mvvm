package com.example.hdi_mvvm.vm

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class XmlViewModel : ViewModel() {

    // 使用LiveData 可观察数据源
    var userName = MutableLiveData<String>("")

    var pwd = MutableLiveData<String>("")

    fun onLogin(view: View) {
        Toast.makeText(view.context, "userName:${userName.value} pwd${pwd.value}", Toast.LENGTH_LONG).show()
    }

}