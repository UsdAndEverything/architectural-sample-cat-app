package com.usd.catapplication.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cat(
    val adaptability: Int,
    val affection_level: Int,
    val alt_names: String?,
    val bidability: Int,
    val cat_friendly: Int,
    val child_friendly: Int,
    val country_code: String,
    val country_codes: String,
    val description: String,
    val dog_friendly: Int,
    val energy_level: Int,
    val experimental: Int,
    val grooming: Int,
    val hairless: Int,
    val health_issues: Int,
    val hypoallergenic: Int,
    @PrimaryKey
    val id: String,
    @Embedded
    val image: Image?,
    val indoor: Int,
    val intelligence: Int,
    val lap: Int,
    val life_span: String,
    val name: String,
    val natural: Int,
    val origin: String,
    val rare: Int,
    val reference_image_id: String?,
    val rex: Int,
    val shedding_level: Int,
    val short_legs: Int,
    val social_needs: Int,
    val stranger_friendly: Int,
    val suppressed_tail: Int,
    val temperament: String,
    val vocalisation: Int,
    @Embedded
    val weight: Weight,
    val wikipedia_url: String?
)

data class Image(
    val height: Int?,
    val url: String?,
    val width: Int?
)

data class Weight(
    val imperial: String,
    val metric: String
)