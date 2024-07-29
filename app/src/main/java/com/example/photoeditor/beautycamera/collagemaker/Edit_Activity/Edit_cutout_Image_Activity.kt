package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.photoeditor.beautycamera.collagemaker.Class.BackgroundRemover
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditCutoutImageBinding

class Edit_cutout_Image_Activity : AppCompatActivity() {

    lateinit var binding: ActivityEditCutoutImageBinding
    private lateinit var backgroundRemover: BackgroundRemover

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCutoutImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backgroundRemover = BackgroundRemover(this)
        initView()
    }

    private fun initView() {
        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            val inputStream = contentResolver.openInputStream(imageUri)
            val bitmap = BitmapFactory.decodeStream(inputStream)

            // Set the original image
            binding.imageView.setImageBitmap(bitmap)

            // Remove background and update the image
            val processedBitmap = backgroundRemover.removeBackground(bitmap)
            binding.imageView.setImageBitmap(processedBitmap)
        }

        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        binding.autoButton.setOnClickListener {
            changeButtonBackgrounds(isAuto = true)
            // Trigger AI processing if needed
        }

        binding.aiPreciseButton.setOnClickListener {
            changeButtonBackgrounds(isAuto = false)
            // Trigger AI processing if needed
        }
    }

    private fun changeButtonBackgrounds(isAuto: Boolean) {
        val blueBackground = ContextCompat.getDrawable(this, R.drawable.button_background_blue)
        val grayBackground = ContextCompat.getDrawable(this, R.drawable.button_background_gray)
        val whiteTextColor = ContextCompat.getColor(this, android.R.color.white)
        val blackTextColor = ContextCompat.getColor(this, android.R.color.black)

        if (isAuto) {
            binding.autoButton.background = blueBackground
            binding.autoText.setTextColor(whiteTextColor)
            binding.aiPreciseButton.background = grayBackground
            binding.aiPreciseText.setTextColor(blackTextColor)
        } else {
            binding.autoButton.background = grayBackground
            binding.autoText.setTextColor(blackTextColor)
            binding.aiPreciseButton.background = blueBackground
            binding.aiPreciseText.setTextColor(whiteTextColor)
        }
    }
}
