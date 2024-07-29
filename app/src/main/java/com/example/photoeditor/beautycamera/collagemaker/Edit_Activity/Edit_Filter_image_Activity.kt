package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.Class.GPUImageNoiseFilter
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditFilterImageBinding
import jp.co.cyberagent.android.gpuimage.GPUImage
import jp.co.cyberagent.android.gpuimage.filter.*

class Edit_Filter_image_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEditFilterImageBinding
    private lateinit var gpuImage: GPUImage
    private val appliedFilters = mutableListOf<GPUImageFilter>()
    private lateinit var originalBitmap: Bitmap

    private var isFilterSectionVisible: Boolean = true
    private var isAdjustSectionVisible: Boolean = false

    companion object {
        const val EXTRA_IMAGE_URI = "com.example.photoeditor.beautycamera.collagemaker.IMAGE_URI"
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditFilterImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initView() {
        gpuImage = GPUImage(this)

        val imageUriString = intent.getStringExtra(EXTRA_IMAGE_URI)
        if (!imageUriString.isNullOrEmpty()) {
            val imageUri = Uri.parse(imageUriString)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                loadImage(imageUri)
            } else {
                loadImageLegacy(imageUri)
            }
        }

        binding.filterSection.visibility = View.VISIBLE
        binding.adjustSection.visibility = View.GONE

        updateButtonStates(binding.filterIcon)

        binding.filterIcon.setOnClickListener {
            if (!isFilterSectionVisible) {
                toggleSections(isFilterSectionVisible = true)
                updateButtonStates(binding.filterIcon)
            }
        }

        binding.adjustIcon.setOnClickListener {
            if (!isAdjustSectionVisible) {
                toggleSections(isFilterSectionVisible = false)
                updateButtonStates(binding.adjustIcon)
            }
        }

        setupFilterButtons()
        setupAdjustmentOptions()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun loadImage(uri: Uri) {
        val source = ImageDecoder.createSource(contentResolver, uri)
        originalBitmap = ImageDecoder.decodeBitmap(source).copy(Bitmap.Config.ARGB_8888, true)!!
        gpuImage.setImage(originalBitmap)
        binding.mainImage.setImageBitmap(originalBitmap)
    }

    @Suppress("DEPRECATION")
    private fun loadImageLegacy(uri: Uri) {
        originalBitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri).copy(Bitmap.Config.ARGB_8888, true)!!
        gpuImage.setImage(originalBitmap)
        binding.mainImage.setImageBitmap(originalBitmap)
    }

    private fun addFilter(filter: GPUImageFilter) {
        appliedFilters.add(filter)
        updateImage()
    }

    private fun setAdjustmentFilter(filter: GPUImageFilter, text: String) {
        appliedFilters.removeAll { it::class == filter::class }
        appliedFilters.add(filter)
        binding.seekbarText.text = text
        updateImage()
    }

    private fun updateAdjustment(progress: Int) {
        appliedFilters.forEach {
            when (it) {
                is GPUImageBrightnessFilter -> it.setBrightness(range(progress, -1.0f, 1.0f))
                is GPUImageContrastFilter -> it.setContrast(range(progress, 0.0f, 2.0f))
                is GPUImageWhiteBalanceFilter -> it.setTemperature(range(progress, 2000.0f, 8000.0f))
                is GPUImageSaturationFilter -> it.setSaturation(range(progress, 0.0f, 2.0f))
                is GPUImageExposureFilter -> it.setExposure(range(progress, -2.0f, 2.0f))
                is GPUImageHighlightShadowFilter -> {
                    if (binding.seekbarText.text == "Highlight") {
                        it.setHighlights(range(progress, 0.0f, 1.0f))
                    } else if (binding.seekbarText.text == "Shadow") {
                        it.setShadows(range(progress, 0.0f, 1.0f))
                    }
                }
                is GPUImageHueFilter -> it.setHue(range(progress, 0.0f, 360.0f))
                is GPUImageNoiseFilter -> it.setIntensity(range(progress, 0.0f, 0.5f))
                is GPUImageRGBFilter -> {
                    val value = range(progress, 0.0f, 2.0f)
                    it.setRed(value)
                    it.setGreen(value)
                    it.setBlue(value)
                }
            }
        }
        updateImage()
    }

    private fun updateImage() {
        gpuImage.setFilter(GPUImageFilterGroup(appliedFilters))
        binding.mainImage.setImageBitmap(gpuImage.bitmapWithFilterApplied)
    }

    private fun updateButtonStates(selectedButton: View) {
        binding.filterIcon.alpha = if (selectedButton == binding.filterIcon) 1.0f else 0.5f
        binding.adjustIcon.alpha = if (selectedButton == binding.adjustIcon) 1.0f else 0.5f
    }

    private fun range(progress: Int, min: Float, max: Float): Float {
        return min + (max - min) * (progress / 100.0f)
    }

    private fun createLomoFilter(): GPUImageFilter {
        val colorMatrix = floatArrayOf(
            1.4f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.4f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.4f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f
        )
        return GPUImageColorMatrixFilter(1.0f, colorMatrix)
    }

    private fun createPinkFilter(): GPUImageFilter {
        val colorMatrix = floatArrayOf(
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.5f, 0.0f, 0.5f, 1.0f
        )
        return GPUImageColorMatrixFilter(1.0f, colorMatrix)
    }

    private fun toggleSections(isFilterSectionVisible: Boolean) {
        binding.filterSection.visibility = if (isFilterSectionVisible) View.VISIBLE else View.GONE
        binding.adjustSection.visibility = if (isFilterSectionVisible) View.GONE else View.VISIBLE
        this.isFilterSectionVisible = isFilterSectionVisible
        this.isAdjustSectionVisible = !isFilterSectionVisible
    }

    private fun setupFilterButtons() {
        binding.filterOrignal.setOnClickListener { addFilter(GPUImageFilter()) }
        binding.filterBright.setOnClickListener { addFilter(GPUImageBrightnessFilter(1.5f)) }
        binding.filterStory.setOnClickListener { addFilter(GPUImageSepiaToneFilter()) }
        binding.filterNature.setOnClickListener { addFilter(GPUImageContrastFilter(2.0f)) }
        binding.filterWarm.setOnClickListener { addFilter(GPUImageWhiteBalanceFilter(5000.0f, 0.0f)) }
        binding.filterDew.setOnClickListener { addFilter(GPUImageVignetteFilter()) }
        binding.filterGold.setOnClickListener { addFilter(GPUImageToneCurveFilter()) }
        binding.filterLomo.setOnClickListener { addFilter(createLomoFilter()) }
        binding.filterPink.setOnClickListener { addFilter(createPinkFilter()) }

    }

    private fun setupAdjustmentOptions() {
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                updateAdjustment(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.linearBrightnes.setOnClickListener {
            setAdjustmentFilter(GPUImageBrightnessFilter(), "Brightness")
        }
        binding.linearContrast.setOnClickListener {
            setAdjustmentFilter(GPUImageContrastFilter(), "Contrast")
        }
        binding.linearWarmth.setOnClickListener {
            setAdjustmentFilter(GPUImageWhiteBalanceFilter(), "Warmth")
        }
        binding.linearSaturation.setOnClickListener {
            setAdjustmentFilter(GPUImageSaturationFilter(), "Saturation")
        }
        binding.linearFade.setOnClickListener {
            setAdjustmentFilter(GPUImageExposureFilter(), "Fade")
        }
        binding.linearHighlight.setOnClickListener {
            setAdjustmentFilter(GPUImageHighlightShadowFilter().apply { setHighlights(1.5f) }, "Highlight")
        }
        binding.linearShadow.setOnClickListener {
            setAdjustmentFilter(GPUImageHighlightShadowFilter().apply { setShadows(1.5f) }, "Shadow")
        }
        binding.linearTint.setOnClickListener {
            setAdjustmentFilter(GPUImageRGBFilter(1.0f, 0.0f, 1.0f), "Tint")
        }
        binding.linearHue.setOnClickListener {
            setAdjustmentFilter(GPUImageHueFilter(), "Hue")
        }
        binding.linearGrain.setOnClickListener {
            setAdjustmentFilter(GPUImageNoiseFilter(), "Grain")
        }
    }
}
