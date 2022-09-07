package com.usd.catapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.usd.catapplication.R
import com.usd.catapplication.data.Resource
import com.usd.catapplication.databinding.ActivityCatListBinding
import com.usd.catapplication.model.Cat
import com.usd.catapplication.ui.adapter.CatsAdapter
import com.usd.catapplication.ui.fragment.CatBreedDetailFragment
import com.usd.catapplication.ui.viewmodel.CatListViewModel
import com.usd.catapplication.ui.viewmodel.viewmodelfactory.CatListViewModelFactory
import com.usd.catapplication.util.Constants.TAG_CAT_BREED_DETAIL
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatListActivity : AppCompatActivity() {

    lateinit var viewModel: CatListViewModel
    lateinit var binding: ActivityCatListBinding
    @Inject
    lateinit var viewModelFactory: CatListViewModelFactory
    private lateinit var adapter: CatsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_list)
        viewModel = ViewModelProvider(this, viewModelFactory)[CatListViewModel::class.java]

        setObservers()
        initRecyclerView()
        fetchCatList()
    }

    private fun setObservers() {
        viewModel.catBreedList.observe(this, Observer { response ->
            when (response) {

                is Resource.Loading -> {
                    showProgressIndicator()
                }

                is Resource.Success -> {
                    loadMovieList(response.data)
                }

                is Resource.Error -> {
                    hideProgressIndicator()
                }

            }
        })
    }

    private fun fetchCatList() {
        viewModel.getCatList()
    }

    private fun showProgressIndicator() {

    }

    private fun hideProgressIndicator() {

    }

    private fun loadMovieList(catList: List<Cat>?) {
        catList?.let { list ->
            adapter.differ.submitList(list)
        }
    }

    private fun initRecyclerView() {
        binding.rvCats.layoutManager = LinearLayoutManager(this)
        adapter = CatsAdapter()
        binding.rvCats.adapter = adapter
        adapter.itemClickListener = { cat ->
            launchCatBreedDetailFragment(cat)
        }
    }

    private fun launchCatBreedDetailFragment(cat: Cat) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val catBreedDetailFragment = CatBreedDetailFragment()
        catBreedDetailFragment.cat = cat
        fragmentTransaction.replace(R.id.container_cat_breed_detail, catBreedDetailFragment, TAG_CAT_BREED_DETAIL)
                .addToBackStack(TAG_CAT_BREED_DETAIL)
        fragmentTransaction.commit()
    }

}