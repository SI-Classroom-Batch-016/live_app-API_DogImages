package com.example.apiliveapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apiliveapp.R
import com.example.apiliveapp.databinding.ImageItemBinding

class ImageAdapter(
    val dataset: List<String>
) : RecyclerView.Adapter<ImageAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        Log.d("ImageUrl", item)

        //Coil nutzen um das Bild in die ImageView im holder zu laden
        holder.binding.imageView.load(item) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
        }

    }
}