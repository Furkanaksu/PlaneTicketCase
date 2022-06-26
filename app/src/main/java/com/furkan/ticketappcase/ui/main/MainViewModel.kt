package com.furkan.ticketappcase.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkan.ticketappcase.data.api.Resource
import com.furkan.ticketappcase.data.model.Data
import com.furkan.ticketappcase.data.repository.SongsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataRepository: SongsRepo) : ViewModel() {

    private val _getData: MutableLiveData<Data?> = MutableLiveData()
    val getData: LiveData<Data?>
        get() = _getData

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    fun getData(context : Context) = viewModelScope.launch {
        CoroutineScope(Dispatchers.IO).launch {  }
        when (val response = dataRepository.getData(context)) {
            is Resource.Success -> {
                _getData.postValue(response.data)
            }
            is Resource.Error -> {
                _error.postValue(response.message.toString())
            }
        }
    }
}