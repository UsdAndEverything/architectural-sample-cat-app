package com.usd.catapplication.data.repository

import com.usd.catapplication.data.Resource
import com.usd.catapplication.data.localdatasource.LocalDataSource
import com.usd.catapplication.data.remotedatasource.RemoteDataSource
import com.usd.catapplication.model.Cat
import retrofit2.Response

class CatRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : CatRepository {

    override suspend fun getCatBreedsList(): Resource<List<Cat>> {
        return responseToResource(remoteDataSource.getCatBreedsList())
    }

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        return if (response.isSuccessful) {
            Resource.Success(response.body())
        } else {
            Resource.Error("An error occurred")
        }
    }

}