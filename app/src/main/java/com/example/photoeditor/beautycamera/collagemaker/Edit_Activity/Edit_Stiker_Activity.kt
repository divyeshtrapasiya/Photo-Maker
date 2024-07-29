package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditStikerBinding

class Edit_Stiker_Activity : AppCompatActivity() {

    lateinit var binding : ActivityEditStikerBinding

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStikerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        val imageUriString = intent.getStringExtra(Edit_Filter_image_Activity.EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            binding.imgEditSelectImagess.setImageURI(imageUri)
        }

    }
}