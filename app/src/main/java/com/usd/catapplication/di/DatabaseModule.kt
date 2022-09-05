package com.usd.catapplication.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.usd.catapplication.App
import com.usd.catapplication.data.database.CatDao
import com.usd.catapplication.data.database.CatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideCatDao(catDatabase: CatDatabase): CatDao {
        return catDatabase.catDao()
    }

    @Provides
    @Singleton
    fun provideCatDatabase(): CatDatabase {
        return Room.databaseBuilder(App.app, CatDatabase::class.java, "cat_db")
            .build()
    }


}