package com.usd.catapplication.data.remotedatasource

import com.usd.catapplication.data.network.ApiService
import com.usd.catapplication.model.Cat
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun getCatBreedsList(): Response<List<Cat>> {
        return apiService.getCatBreeds()
    }

}