package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityCropImageBinding
import com.example.photoeditor.beautycamera.collagemaker.R

class Crop_Image_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityCropImageBinding
    private var isRotateSectionVisible: Boolean = false
    private var isPerspectiveSectionVisible: Boolean = false

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCropImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()



    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initView() {


        binding.buttonsRotateSection.visibility = View.VISIBLE
        binding.buttonPerspectiveSection.visibility = View.GONE


        updateButtonStates(binding.rotateButton)

        binding.rotateButton.setOnClickListener {
            if (!isRotateSectionVisible) {
                binding.buttonsRotateSection.visibility = View.VISIBLE
                binding.buttonPerspectiveSection.visibility = View.GONE
                isRotateSectionVisible = true
                isPerspectiveSectionVisible = false
                updateButtonStates(binding.rotateButton)
            }
        }

        binding.perspectiveButton.setOnClickListener {
            if (!isPerspectiveSectionVisible) {
                binding.buttonPerspectiveSection.visibility = View.VISIBLE
                binding.buttonsRotateSection.visibility = View.GONE
                isPerspectiveSectionVisible = true
                isRotateSectionVisible = false
                updateButtonStates(binding.perspectiveButton)
            }
        }


        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            Glide.with(this)
                .asBitmap()
                .load(imageUri)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        binding.cropImageView.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
        } else {
            finish()
        }

        binding.relativeLeft90.setOnClickListener {
            binding.cropImageView.rotateImage(-90)
        }

        binding.relativeRight90.setOnClickListener {
            binding.cropImageView.rotateImage(90)
        }

        binding.linearHorizontal.setOnClickListener {
            flipImageHorizontally()
        }

        binding.linearVertical.setOnClickListener {
            flipImageVertically()
        }

        // Add scale functionality
        binding.imageScale.setOnClickListener {
            scaleImage(1.5f) // Example scale factor
        }
    }



    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateButtonStates(selectedButton: View) {
        binding.rotateButton.setBackgroundResource(
            if (selectedButton == binding.rotateButton)
                R.drawable.button_background_selected
            else
                R.drawable.button_background_unselected
        )
        binding.perspectiveButton.setBackgroundResource(
            if (selectedButton == binding.perspectiveButton)
                R.drawable.button_background_selected
            else
                R.drawable.button_background_unselected
        )

        binding.textRotate.isSelected = (selectedButton == binding.rotateButton)
        binding.textRotate.setTextColor(
            if (selectedButton == binding.rotateButton)
                getColor(R.color.selected_text_color)
            else
                getColor(R.color.unselected_text_color)
        )

        binding.textPerspective.isSelected = (selectedButton == binding.perspectiveButton)
        binding.textPerspective.setTextColor(
            if (selectedButton == binding.perspectiveButton)
                getColor(R.color.selected_text_color)
            else
                getColor(R.color.unselected_text_color)
        )
    }

    private fun flipImageHorizontally() {
        val bitmap = binding.cropImageView.croppedImage
        val matrix = android.graphics.Matrix().apply {
            postScale(-1f, 1f, bitmap.width / 2f, bitmap.height / 2f)
        }
        val flippedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        binding.cropImageView.setImageBitmap(flippedBitmap)
    }

    private fun flipImageVertically() {
        val bitmap = binding.cropImageView.croppedImage
        val matrix = android.graphics.Matrix().apply {
            postScale(1f, -1f, bitmap.width / 2f, bitmap.height / 2f)
        }
        val flippedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        binding.cropImageView.setImageBitmap(flippedBitmap)
    }

    private fun scaleImage(scaleFactor: Float) {
        val bitmap = binding.cropImageView.croppedImage
        val matrix = android.graphics.Matrix().apply {
            // Horizontal scaling only
            postScale(scaleFactor, 1f, bitmap.width / 2f, bitmap.height / 2f)
        }
        val scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
        binding.cropImageView.setImageBitmap(scaledBitmap)
    }
}
