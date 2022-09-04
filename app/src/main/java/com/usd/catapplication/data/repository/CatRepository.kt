package com.usd.catapplication.data.repository

import com.usd.catapplication.data.Resource
import com.usd.catapplication.model.Cat

interface CatRepository {

    suspend fun getCatBreedsList(): Resource<List<Cat>>

}