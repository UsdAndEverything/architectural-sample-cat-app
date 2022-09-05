package com.usd.catapplication.di

import com.usd.catapplication.data.database.CatDao
import com.usd.catapplication.data.localdatasource.LocalDataSource
import com.usd.catapplication.data.localdatasource.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(catDao: CatDao): LocalDataSource {
        return LocalDataSourceImpl(catDao)
    }

}