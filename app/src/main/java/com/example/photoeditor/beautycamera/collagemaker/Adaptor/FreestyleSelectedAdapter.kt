package com.example.photoeditor.beautycamera.collagemaker.Adaptor

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity.Freestyle_Background_Activity
import com.example.photoeditor.beautycamera.collagemaker.R

class FreestyleSelectedAdapter(
    private val context: Context,
    private val selectedImagesList: List<Uri>
) : RecyclerView.Adapter<FreestyleSelectedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.freestyle_item_selected_image, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uri = selectedImagesList[position]
        holder.imageView.setImageURI(uri)
        holder.itemView.setOnClickListener {
            // Update the ImageView in Freestyle_Background_Activity when an item is clicked
            if (context is Freestyle_Background_Activity) {
//                context.binding..setImageURI(uri)
            }
        }
    }

    override fun getItemCount(): Int {
        return selectedImagesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.selectedimageview)
    }
}
