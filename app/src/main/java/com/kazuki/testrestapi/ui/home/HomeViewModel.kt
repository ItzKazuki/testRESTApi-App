package com.kazuki.testrestapi.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kazuki.testrestapi.model.User
import com.kazuki.testrestapi.network.RestApi
import com.kazuki.testrestapi.network.RetrofitBuilder
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _apiUserRes = MutableLiveData<List<User>>()
    val apiUserRes: LiveData<List<User>> = _apiUserRes

    val apiService = RetrofitBuilder.retrofit.create(RestApi::class.java)

    fun getListUser() {
        viewModelScope.launch {
            try {
                val resApi = apiService.getDataUser()
                if(resApi.isSuccessful) {
                    // add arraylistof untuk set datanya kalo kosong(dari server) bakal di set ke array kosong
                    val data = resApi.body() ?: arrayListOf()
                    _apiUserRes.postValue(data)
                } else {
                    val error = resApi.errorBody()
                }
            } catch(e: Exception) {
                Log.d("msg", e.message.toString())
            }
        }
    }
}