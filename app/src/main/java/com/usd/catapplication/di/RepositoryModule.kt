package com.usd.catapplication.di

import com.usd.catapplication.data.localdatasource.LocalDataSource
import com.usd.catapplication.data.remotedatasource.RemoteDataSource
import com.usd.catapplication.data.repository.CatRepository
import com.usd.catapplication.data.repository.CatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCatRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): CatRepository {
        return CatRepositoryImpl(localDataSource, remoteDataSource)
    }


}