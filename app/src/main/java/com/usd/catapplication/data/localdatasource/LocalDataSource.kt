package com.usd.catapplication.data.localdatasource

import com.usd.catapplication.model.Cat

interface LocalDataSource {

    suspend fun getCatBreeds(): List<Cat>

    suspend fun deleteAllCatBreeds()

    suspend fun saveAllCatBreeds(catBreeds: List<Cat>)

}