package com.example.typicode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.typicode.databinding.ItemPhotoBinding
import com.squareup.picasso.Picasso

class PhotoListAdapter(private val onItemClick: (String, String, String) -> Unit) : RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>() {

        private var images: List<PhotoList> = listOf()

        fun setPhotos(images: List<PhotoList>) {
            this.images = images
            notifyDataSetChanged()
        }

        inner class PhotoViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(image: PhotoList) {
                binding.photo = image

                binding.viewDetails.setOnClickListener {onItemClick(image.url, image.title,image.albumId.toString()) }
                Picasso.get()
                    .load(image.thumbnailUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.setup)
                    .into(binding.photoImage)
                binding.executePendingBindings()
            }
              /*  binding.root.setOnClickListener { onItemClick(image.url, image.title,image.albumId.toString()) }
                Picasso.get()
                    .load(image.thumbnailUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.setup)
                    .into(binding.photoImage)
                binding.executePendingBindings()
            }*/
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
            val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PhotoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
            holder.bind(images[position])

        }

        override fun getItemCount(): Int = images.size
    }
