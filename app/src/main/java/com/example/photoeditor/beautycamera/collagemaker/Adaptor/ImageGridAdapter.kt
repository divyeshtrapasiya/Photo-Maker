package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.photoeditor.beautycamera.collagemaker.R
import java.io.File
import java.io.IOException

class ImageGridAdapter(private val context: Context, private val imageUris: List<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return imageUris.size
    }

    override fun getItem(position: Int): Any {
        return imageUris[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val gridView: View
        val holder: ViewHolder

        if (convertView == null) {
            gridView = inflater.inflate(R.layout.grid_item_layout, parent, false)
            holder = ViewHolder(gridView.findViewById(R.id.image_view))
            gridView.tag = holder  // Save ViewHolder in the tag
        } else {
            gridView = convertView
            holder = gridView.tag as ViewHolder  // Retrieve ViewHolder from tag
        }

        // Load image from URI
        val uri = Uri.parse(imageUris[position])
        try {
            val inputStream = context.contentResolver.openInputStream(uri)
            if (inputStream != null) {
                val bitmap = BitmapFactory.decodeStream(inputStream)
                holder.imageView.setImageBitmap(bitmap)
            } else {
                Log.e("ImageGridAdapter", "Input stream null for URI: $uri")
                holder.imageView.setImageResource(R.drawable.ic_launcher_background) // Placeholder image on error
            }
        } catch (e: IOException) {
            Log.e("ImageGridAdapter", "Error loading image from URI: $uri", e)
            holder.imageView.setImageResource(R.drawable.ic_launcher_background) // Placeholder image on error
        }

        return gridView
    }

    private class ViewHolder(val imageView: ImageView)
}
