package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeStoreViewModel : ViewModel() {

    private val _shoesList : MutableLiveData<List<Shoe>> = MutableLiveData()

    val shoesList : LiveData<List<Shoe>>
        get() = _shoesList
}