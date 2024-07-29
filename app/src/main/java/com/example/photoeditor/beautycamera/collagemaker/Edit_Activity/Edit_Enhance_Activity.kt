package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditEnhanceBinding

class Edit_Enhance_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEditEnhanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditEnhanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initview() {
        val imageUriString = intent.getStringExtra(Edit_Filter_image_Activity.EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            binding.originalImage.setImageURI(imageUri)
            val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
            binding.blurredImage.setImageBitmap(blurBitmap(bitmap))
        }

        val divider = binding.divider
        val dividerHandle = binding.dividerHandle

        dividerHandle.setOnTouchListener(object : View.OnTouchListener {
            var dX = 0f

            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        dX = view.x - event.rawX
                        return true
                    }
                    MotionEvent.ACTION_MOVE -> {
                        val parentWidth = (view.parent as View).width
                        val newX = event.rawX + dX
                        if (newX >= 0 && newX <= parentWidth - view.width) {
                            view.x = newX
                            divider.x = newX + view.width / 2 - divider.width / 2
                            updateImageVisibility(newX)
                        }
                        return true
                    }
                }
                return false
            }
        })
    }

    private fun blurBitmap(bitmap: Bitmap): Bitmap {
        val outputBitmap = Bitmap.createBitmap(bitmap)
        val renderScript = RenderScript.create(this)
        val input = Allocation.createFromBitmap(renderScript, bitmap)
        val output = Allocation.createFromBitmap(renderScript, outputBitmap)
        val script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
        script.setRadius(10f) // Set the blur radius
        script.setInput(input)
        script.forEach(output)
        output.copyTo(outputBitmap)
        return outputBitmap
    }

    private fun updateImageVisibility(dividerPosition: Float) {
        val width = binding.imageContainer.width
        val ratio = dividerPosition / width
        val leftVisibleWidth = (width * ratio).toInt()
        binding.originalImage.clipBounds = android.graphics.Rect(0, 0, leftVisibleWidth, binding.originalImage.height)
        binding.blurredImage.clipBounds = android.graphics.Rect(leftVisibleWidth, 0, width, binding.blurredImage.height)
    }
}
