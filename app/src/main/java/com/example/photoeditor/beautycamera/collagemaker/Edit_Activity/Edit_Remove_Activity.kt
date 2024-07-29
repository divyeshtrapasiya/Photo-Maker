package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditRemoveBinding
import java.io.InputStream

class Edit_Remove_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRemoveBinding

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRemoveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            var inputStream: InputStream? = null
            try {
                inputStream = contentResolver.openInputStream(imageUri)
                val bitmap = BitmapFactory.decodeStream(inputStream)

                // Ensure the view has been laid out before setting the bitmap
                binding.overlayView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        binding.overlayView.setImageBitmap(bitmap)
                        binding.overlayView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                })
            } finally {
                inputStream?.close()
            }
        }

        binding.sizeSlider.max = 100
        binding.sizeSlider.progress = 50

        binding.sizeSlider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.sizeValue.text = progress.toString()
                binding.overlayView.setCircleRadius(progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


    }
}
