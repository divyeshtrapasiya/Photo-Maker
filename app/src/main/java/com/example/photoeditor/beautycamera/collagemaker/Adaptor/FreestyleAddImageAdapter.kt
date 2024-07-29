package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photoeditor.beautycamera.collagemaker.databinding.GridItemImageBinding
import com.example.photoeditor.beautycamera.collagemaker.databinding.ItemCameraBinding

class FreestyleAddImageAdapter(
    private val context: Context,
    private val imageUris: List<Uri>,
    private val itemClickListener: (Uri) -> Unit,
    private val cameraClickListener: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_IMAGE = 1
    private val VIEW_TYPE_CAMERA = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_IMAGE) {
            val binding = GridItemImageBinding.inflate(LayoutInflater.from(context), parent, false)
            ImageViewHolder(binding)
        } else {
            val binding = ItemCameraBinding.inflate(LayoutInflater.from(context), parent, false)
            CameraViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> holder.bind(imageUris[position - 1])
            is CameraViewHolder -> holder.bindCamera()
        }
    }

    override fun getItemCount(): Int = imageUris.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_CAMERA
        } else {
            VIEW_TYPE_IMAGE
        }
    }

    inner class ImageViewHolder(private val binding: GridItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(uri: Uri) {
            binding.imageView.setImageURI(uri)
            binding.root.setOnClickListener {
                itemClickListener(uri)
            }
        }
    }

    inner class CameraViewHolder(private val binding: ItemCameraBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindCamera() {
            binding.cameraIcon.setOnClickListener {
                cameraClickListener()
            }
        }
    }
}
