package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreameImageBinding

class Freame_image_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreameImageBinding

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreameImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()


    }

    private fun initview() {

        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            binding.selectedImage.setImageURI(imageUri)
        }

        // Set click listener for shape button
        binding.relativeShape.setOnClickListener {
            showShapeDialog()
        }

    }

    private fun showShapeDialog() {
        val dialog = Dialog(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_custom_shape, null)
        dialog.setContentView(dialogView)
//
//
//        dialogView.findViewById<Button>(R.id.button_shape_1).setOnClickListener {
//
//            dialog.dismiss()
//        }
//
//        dialogView.findViewById<Button>(R.id.button_shape_2).setOnClickListener {
//
//            dialog.dismiss()
//        }



        dialog.show()
    }
}
