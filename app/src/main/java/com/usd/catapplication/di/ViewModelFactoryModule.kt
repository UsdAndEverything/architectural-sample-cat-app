package com.usd.catapplication.di

import com.usd.catapplication.App
import com.usd.catapplication.domain.usecase.GetCatBreedsUseCase
import com.usd.catapplication.ui.viewmodel.viewmodelfactory.CatListViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideCatListViewModelFactory(getCatBreedsUseCase: GetCatBreedsUseCase): CatListViewModelFactory {
        return CatListViewModelFactory(App.app, getCatBreedsUseCase)
    }

}