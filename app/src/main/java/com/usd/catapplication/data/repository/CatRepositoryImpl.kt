package com.usd.catapplication.data.repository

import android.util.Log
import com.usd.catapplication.data.Resource
import com.usd.catapplication.data.localdatasource.LocalDataSource
import com.usd.catapplication.data.remotedatasource.RemoteDataSource
import com.usd.catapplication.model.Cat
import com.usd.catapplication.util.Constants.LOCAL_DATA_SOURCE_TTL
import com.usd.catapplication.util.SharedPreferencesUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response

class CatRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : CatRepository {

    override suspend fun getCatBreedsList(): Resource<List<Cat>> {
        return try {
            val localSourceData = localDataSource.getCatBreeds()
            if (localSourceData.isEmpty() || cacheExpired()) {
                Log.d("hereee", "before remote")
                val response = remoteDataSource.getCatBreedsList()
                Log.d("hereee", "after remote")
                CoroutineScope(IO).launch {
                    Log.d("hereee", "before local")
                    updateCatBreeds(response)
                    Log.d("hereee", "after local")
                }
                Log.d("hereee", "before result")
                responseToResource(response)
            } else {
                Log.d("hereee", "before local result")
                Resource.Success(localSourceData)
            }
        } catch (e: Exception) {
            Resource.Error(message = e.message)
        }
    }

    private suspend fun updateCatBreeds(response: Response<List<Cat>>) {
        localDataSource.deleteAllCatBreeds()
        if (response.isSuccessful) {
            response.body()?.let {
                localDataSource.saveAllCatBreeds(it)
                SharedPreferencesUtil.setCatBreedsRemoteSourceFetchTimeStamp()
            }
        }
    }

    private fun <T> responseToResource(response: Response<T>): Resource<T> {
        return if (response.isSuccessful) {
            Resource.Success(response.body())
        } else {
            Resource.Error("An error occurred")
        }
    }

    private fun cacheExpired(): Boolean {
        SharedPreferencesUtil.getCatBreedsRemoteSourceFetchTimeStamp()?.toLongOrNull()
            ?.let { lastFetchTimeStamp ->
                return (System.currentTimeMillis() - lastFetchTimeStamp) > LOCAL_DATA_SOURCE_TTL
            }
        return true
    }

}