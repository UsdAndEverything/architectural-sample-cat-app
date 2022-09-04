package com.usd.catapplication.ui.viewmodel.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.usd.catapplication.domain.usecase.GetCatBreedsUseCase
import com.usd.catapplication.ui.viewmodel.CatListViewModel

class CatListViewModelFactory(
    private val application: Application,
    private val getCatBreedsUseCase: GetCatBreedsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatListViewModel::class.java)) {
            return CatListViewModel(application, getCatBreedsUseCase) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }

}