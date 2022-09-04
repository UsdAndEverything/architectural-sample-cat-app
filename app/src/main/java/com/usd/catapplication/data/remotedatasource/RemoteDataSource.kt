package com.usd.catapplication.data.remotedatasource

import com.usd.catapplication.model.Cat
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getCatBreedsList(): Response<List<Cat>>

}