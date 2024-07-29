package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity


import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditImageBinding

class Edit_Image_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEditImageBinding

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        binding.relativeEnhance.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Edit_Enhance_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }

        }

        binding.relativeStiker.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Edit_Stiker_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }

        }

        binding.relativeAdd.setOnClickListener {

                val intent = Intent(this, Edit_Stiker_Activity::class.java)
                startActivity(intent)

        }


        binding.relativeCutout.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Edit_cutout_Image_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }

        }


        binding.relativeFilter.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Edit_Filter_image_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }

        }


        binding.relativeAdjust.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Edit_Adjust_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }
        }

        binding.relativeRemove.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Edit_Remove_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }

        }



        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            binding.imageView.setImageURI(imageUri)
        }

        binding.txtRatio.setOnClickListener {

            showRatioDialog()

        }

        binding.txtBackground.setOnClickListener {

            showBackgroundDialog()

        }


        binding.relativeCrop.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Crop_Image_Activity::class.java).apply {
                    putExtra(Crop_Image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }
        }

        binding.relativeFreame.setOnClickListener {

            val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
            if (!imageUriString.isNullOrEmpty()) {
                val intent = Intent(this, Freame_image_Activity::class.java).apply {
                    putExtra(Freame_image_Activity.EXTRA_IMAGE_URI, imageUriString)
                }
                startActivity(intent)
            }
        }
    }

    private fun showBackgroundDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_background)

        dialog.window?.setWindowAnimations(android.R.style.Animation_InputMethod)

        val window = dialog.window
        val params = window?.attributes
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        params?.height = WindowManager.LayoutParams.WRAP_CONTENT
        params?.gravity = Gravity.BOTTOM
        window?.attributes = params


        dialog.show()

    }

    private fun showRatioDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_ratio)

        dialog.window?.setWindowAnimations(android.R.style.Animation_InputMethod)

        val window = dialog.window
        val params = window?.attributes
        params?.width = WindowManager.LayoutParams.MATCH_PARENT
        params?.height = WindowManager.LayoutParams.WRAP_CONTENT
        params?.gravity = Gravity.BOTTOM
        window?.attributes = params

        val linear_ig1_1 = dialog.findViewById<LinearLayout>(R.id.linear_ig1_1)
        val ig_4_5_button = dialog.findViewById<LinearLayout>(R.id.ig_4_5_button)
        val ig_5_4_button = dialog.findViewById<LinearLayout>(R.id.ig_5_4_button)

        linear_ig1_1.setOnClickListener {
            handleRatioSelected("1:1")
            dialog.dismiss()
        }

        ig_4_5_button.setOnClickListener {
            handleRatioSelected("4:5")
            dialog.dismiss()

        }

        ig_5_4_button.setOnClickListener {
            handleRatioSelected("5:4")
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun handleRatioSelected(ratio: String) {
        println("Selected ratio: $ratio")
    }
}
