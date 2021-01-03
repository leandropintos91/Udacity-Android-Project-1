package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeStoreViewModel : ViewModel() {
    fun addNewShoe(pName: String, pCompany: String, pSize: String, pDescription: String) {
        shoesList.value!!.add(Shoe(name = pName, company = pCompany, size = pSize.toDouble(), description = pDescription))
    }

    val shoesList : MutableLiveData<MutableList<Shoe>> = MutableLiveData()

    init {
        shoesList.value = mutableListOf()
    }
}