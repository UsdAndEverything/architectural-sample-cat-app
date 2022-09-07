package com.usd.catapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.usd.catapplication.R
import com.usd.catapplication.databinding.FragmentCatBreedDetailBinding
import com.usd.catapplication.model.Cat

class CatBreedDetailFragment : Fragment() {

    private lateinit var binding: FragmentCatBreedDetailBinding
    lateinit var cat: Cat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_cat_breed_detail, container, false)
        bindData()
        return binding.root
    }

    private fun bindData() {
        if (!this::cat.isInitialized) activity?.onBackPressed()

        setCatBreedImage()
        setCatBreedName()
        setCatBreedDescription()
        setCatBreedOrigin()
        setCatBreedRatings()
    }

    private fun setCatBreedImage() {
        Glide.with(binding.ivCatBreedImage.context)
            .load(cat.image?.url)
            .into(binding.ivCatBreedImage)
    }

    private fun setCatBreedName() {
        binding.tvName.text = cat.name
    }

    private fun setCatBreedDescription() {
        binding.tvDescription.text = cat.description
    }

    private fun setCatBreedOrigin() {
        binding.tvOrigin.text = cat.origin
    }

    private fun setCatBreedRatings() {
        setAffectionLevelRating()
        setAdaptabilityRating()
        setEnergyLevelRating()
        setIntelligenceRating()
        setSheddingLevelRating()
        setChildFriendlyRating()
    }

    private fun setAffectionLevelRating() {
        binding.ratingAffectionLevel.rating = cat.affection_level.toFloat()
    }

    private fun setAdaptabilityRating() {
        binding.ratingAdaptability.rating = cat.adaptability.toFloat()
    }

    private fun setEnergyLevelRating() {
        binding.ratingEnergyLevel.rating = cat.energy_level.toFloat()
    }

    private fun setIntelligenceRating() {
        binding.ratingIntelligence.rating = cat.intelligence.toFloat()
    }

    private fun setChildFriendlyRating() {
        binding.ratingChildFriendly.rating = cat.child_friendly.toFloat()
    }

    private fun setSheddingLevelRating() {
        binding.ratingSheddingLevel.rating = cat.shedding_level.toFloat()
    }

}