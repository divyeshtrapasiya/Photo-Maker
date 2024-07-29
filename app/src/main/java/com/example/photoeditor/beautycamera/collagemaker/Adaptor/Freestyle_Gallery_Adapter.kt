package com.example.photoeditor.beautycamera.collagemaker

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.photoeditor.beautycamera.collagemaker.R

class Freestyle_Gallery_Adapter(private val context: Context, private val images: List<Uri>) : BaseAdapter() {

    companion object {
        private const val VIEW_TYPE_CAMERA = 0
        private const val VIEW_TYPE_IMAGE = 1
    }

    override fun getCount(): Int {
        return images.size + 1
    }

    override fun getItem(position: Int): Any {
        return if (position == 0) Uri.EMPTY else images[position - 1]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_CAMERA else VIEW_TYPE_IMAGE
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return if (getItemViewType(position) == VIEW_TYPE_CAMERA) {
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.freestyle_camera_icon, parent, false)
            view
        } else {
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.freesatyle_gallery_item, parent, false)
            val imageView: ImageView = view.findViewById(R.id.image_view_freestyle)
            Glide.with(context).load(images[position - 1]).into(imageView)
            view
        }
    }
}
