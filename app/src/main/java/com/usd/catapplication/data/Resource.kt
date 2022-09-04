package com.usd.catapplication.data

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Loading<T>(message: String?) : Resource<T>(message = message)

    class Success<T>(data: T?) : Resource<T>(data)

    class Error<T>(message: String?) : Resource<T>(message = message)
}