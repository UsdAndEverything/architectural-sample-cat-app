package com.usd.catapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.usd.catapplication.databinding.ListItemCatBinding
import com.usd.catapplication.model.Cat

class CatsAdapter : RecyclerView.Adapter<CatsAdapter.CatViewHolder>() {

    var itemClickListener: ((Cat) -> Unit)? = null

    private val itemCallback = object : DiffUtil.ItemCallback<Cat>() {

        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, itemCallback)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = ListItemCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = differ.currentList[position]
        holder.bind(cat)
    }

    inner class CatViewHolder(private val binding: ListItemCatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat) {
            binding.tvName.text = cat.name
            binding.tvDescription.text = cat.description
            cat.image?.url?.let { url ->
                Glide.with(binding.ivCatBreedImage.context)
                    .load(url)
                    .into(binding.ivCatBreedImage)
            }
            binding.root.setOnClickListener {
                itemClickListener?.invoke(cat)
            }
        }
    }


}