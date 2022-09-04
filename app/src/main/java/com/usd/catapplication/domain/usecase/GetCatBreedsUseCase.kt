package com.usd.catapplication.domain.usecase

import com.usd.catapplication.data.Resource
import com.usd.catapplication.data.repository.CatRepository
import com.usd.catapplication.model.Cat

class GetCatBreedsUseCase(private val repository: CatRepository) {

    suspend fun execute(): Resource<List<Cat>> {
        return repository.getCatBreedsList()
    }

}