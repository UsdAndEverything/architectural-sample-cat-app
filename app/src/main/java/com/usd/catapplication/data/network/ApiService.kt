package com.usd.catapplication.data.network

import com.usd.catapplication.BuildConfig
import com.usd.catapplication.model.Cat
import com.usd.catapplication.util.Constants.GET_CAT_BREEDS
import com.usd.catapplication.util.Constants.QUERY_PARAM_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GET_CAT_BREEDS)
    suspend fun getCatBreeds(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = BuildConfig.API_KEY
    ): Response<List<Cat>>

}