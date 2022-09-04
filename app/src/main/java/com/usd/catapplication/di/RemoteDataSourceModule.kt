package com.usd.catapplication.di

import com.usd.catapplication.data.network.ApiService
import com.usd.catapplication.data.remotedatasource.RemoteDataSource
import com.usd.catapplication.data.remotedatasource.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }


}