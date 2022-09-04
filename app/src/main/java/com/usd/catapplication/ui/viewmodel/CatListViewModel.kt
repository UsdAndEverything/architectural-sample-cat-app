package com.usd.catapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.usd.catapplication.R
import com.usd.catapplication.data.Resource
import com.usd.catapplication.domain.usecase.GetCatBreedsUseCase
import com.usd.catapplication.model.Cat
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatListViewModel(
    private val app: Application,
    private val getCatBreedsUseCase: GetCatBreedsUseCase
) : AndroidViewModel(app) {

    val catBreedList = MutableLiveData<Resource<List<Cat>>>()

    fun getCatList() {
        catBreedList.postValue(Resource.Loading(app.getString(R.string.please_wait)))
        viewModelScope.launch(IO) {
            val response = getCatBreedsUseCase.execute()
            catBreedList.postValue(response)
        }
    }


}