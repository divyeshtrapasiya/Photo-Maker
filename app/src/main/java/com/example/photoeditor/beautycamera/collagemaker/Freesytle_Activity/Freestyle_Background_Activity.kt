package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoeditor.beautycamera.collagemaker.Freestyle_Selected_Adapter
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleBackgroundBinding

class Freestyle_Background_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleBackgroundBinding
    private val selectedImagesList = arrayListOf<Uri>()
    private lateinit var selectedImagesAdapter: Freestyle_Selected_Adapter

    companion object {
        const val EXTRA_SELECTED_IMAGES = "com.example.photoeditor.beautycamera.collagemaker.SELECTED_IMAGES"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleBackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView() {
        val selectedImagesRecyclerView: RecyclerView = findViewById(R.id.selected_image_recycler_view)
        selectedImagesAdapter = Freestyle_Selected_Adapter(this, selectedImagesList)
        selectedImagesRecyclerView.adapter = selectedImagesAdapter
        selectedImagesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val selectedImageUris = intent.getStringArrayListExtra(EXTRA_SELECTED_IMAGES)
        selectedImageUris?.let {
            selectedImagesList.addAll(it.map { uriString -> Uri.parse(uriString) })
            selectedImagesAdapter.notifyDataSetChanged()

            if (selectedImagesList.isNotEmpty()) {
                binding.mainImage.setImageURI(selectedImagesList[0])
            }

        }
    }
}
