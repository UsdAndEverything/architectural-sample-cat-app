package com.usd.catapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.usd.catapplication.model.Cat

@Dao
interface CatDao {

    @Query("SELECT * FROM cat")
    suspend fun getCatBreeds(): List<Cat>

    @Query("DELETE FROM cat")
    suspend fun deleteAllCatBreeds()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCatBreeds(catBreeds: List<Cat>)

}