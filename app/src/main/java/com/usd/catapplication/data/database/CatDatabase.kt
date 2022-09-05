package com.usd.catapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usd.catapplication.model.Cat
import com.usd.catapplication.model.Image
import com.usd.catapplication.model.Weight

@Database(entities = [Cat::class], version = 1)
abstract class CatDatabase : RoomDatabase(){

    abstract fun catDao(): CatDao

}