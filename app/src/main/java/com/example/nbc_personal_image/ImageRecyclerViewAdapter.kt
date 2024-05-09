package com.example.nbc_personal_image

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nbc_personal_image.databinding.ItemImageBinding
import org.w3c.dom.Document

class ImageRecyclerViewAdapter(private val context: Context): ListAdapter<Document,ImageRecyclerViewAdapter.ImageSearchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
       return ImageSearchViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val document = currentList[position]
        holder.bind(document)
    }
    inner class ImageSearchViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(document: Document){

        }
    }
    companion object{
        private val ImageDiffCallBack = object : DiffUtil.ItemCallback<Document>(){
            override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem == newItem
            }
        }
    }
}