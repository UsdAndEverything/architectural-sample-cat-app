package com.usd.catapplication.di

import com.usd.catapplication.data.repository.CatRepository
import com.usd.catapplication.domain.usecase.GetCatBreedsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetBreedsUseCase(catRepository: CatRepository): GetCatBreedsUseCase {
        return GetCatBreedsUseCase(catRepository)
    }


}