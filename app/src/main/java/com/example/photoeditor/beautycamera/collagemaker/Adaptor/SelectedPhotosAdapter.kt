package com.example.photoeditor.beautycamera.collagemaker

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SelectedImagesAdapter(
    private val context: Context,
    private val selectedImages: List<Uri>
) : RecyclerView.Adapter<SelectedImagesAdapter.SelectedImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_selected_image, parent, false)
        return SelectedImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectedImageViewHolder, position: Int) {
        val imageUri = selectedImages[position]
        Glide.with(context).load(imageUri).into(holder.selectedImageView)
    }

    override fun getItemCount(): Int {
        return selectedImages.size
    }

    class SelectedImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val selectedImageView: ImageView = itemView.findViewById(R.id.image_view)
    }
}
