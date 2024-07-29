package com.example.photoeditor.beautycamera.collagemaker.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoeditor.beautycamera.collagemaker.R
import com.squareup.picasso.Picasso

class TemplateImageAdapter(private val context: Context, private val images: List<Uri>, private val onCameraClick: () -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_CAMERA = 0
    private val VIEW_TYPE_IMAGE = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return if (viewType == VIEW_TYPE_CAMERA) {
            val view = inflater.inflate(R.layout.template_item_camera, parent, false)
            CameraViewHolder(view, onCameraClick)
        } else {
            val view = inflater.inflate(R.layout.template_item_image, parent, false)
            ImageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            holder.bind(images[position - 1]) // Adjust for camera item at position 0
        }
    }

    override fun getItemCount(): Int {
        return images.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_CAMERA else VIEW_TYPE_IMAGE
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(imageUri: Uri) {
            Picasso.get().load(imageUri).into(imageView)
        }
    }

    class CameraViewHolder(itemView: View, onCameraClick: () -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewCamera)

        init {
            imageView.setOnClickListener { onCameraClick() }
        }
    }
}
