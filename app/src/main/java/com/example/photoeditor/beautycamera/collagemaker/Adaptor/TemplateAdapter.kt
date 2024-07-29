package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photoeditor.beautycamera.collagemaker.databinding.ItemTemplateBinding

class TemplateAdapter(
    private val context: Context,
    private var groups: MutableList<String>,
    private val onItemClick: (String) -> Unit

) : RecyclerView.Adapter<TemplateAdapter.ViewHolder>() {

    private val baseUrl = "https://s3.eu-north-1.amazonaws.com/photoeditorbeautycamera.com/photoeditor/images/templates/"

    inner class ViewHolder(private val binding: ItemTemplateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String) {
            Glide.with(itemView.context).load(baseUrl + imageUrl).into(binding.imageView)
            itemView.setOnClickListener {
                onItemClick(imageUrl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = groups[position]
        holder.bind(imageUrl)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newTemplates: List<String>) {
        groups.clear()
        groups.addAll(newTemplates)
        notifyDataSetChanged()
    }
}
