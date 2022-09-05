package com.usd.catapplication.data.localdatasource

import com.usd.catapplication.data.database.CatDao
import com.usd.catapplication.model.Cat

class LocalDataSourceImpl(private val catDao: CatDao) : LocalDataSource {

    override suspend fun getCatBreeds(): List<Cat> {
        return catDao.getCatBreeds()
    }

    override suspend fun deleteAllCatBreeds() {
        return catDao.deleteAllCatBreeds()
    }

    override suspend fun saveAllCatBreeds(catBreeds: List<Cat>) {
        return catDao.saveCatBreeds(catBreeds)
    }

}