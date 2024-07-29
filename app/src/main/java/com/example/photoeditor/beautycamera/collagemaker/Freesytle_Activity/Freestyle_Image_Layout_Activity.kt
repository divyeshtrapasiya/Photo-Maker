package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.photoeditor.beautycamera.collagemaker.Adaptor.ImageGridAdapter
import com.example.photoeditor.beautycamera.collagemaker.Collage_Activity.Collage_Edit_Image_Activity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityCollagePhotoAdditingBinding
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleImageLayoutBinding

class Freestyle_Image_Layout_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleImageLayoutBinding
    private lateinit var imageUris: ArrayList<String>
    private lateinit var gridView: GridView

    private var isRatioSectionVisible: Boolean = false
    private var isLayoutSectionVisible: Boolean = false
    private var isMarginSectionVisible: Boolean = false
    private var isBorderSectionVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleImageLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        showoption()
    }

    private fun showoption() {

        binding.imageright.setOnClickListener {

            val intent = Intent(this, Freestyle_Edit_Image_Activity::class.java)
            startActivity(intent)

        }

        binding.linearRatio.visibility = View.VISIBLE
        binding.linearLayout.visibility = View.GONE
        binding.linearMargin.visibility = View.GONE
        binding.linearBorder.visibility = View.GONE

        underlineText(binding.textRatio)

        binding.textRatio.setOnClickListener {
            if (!isRatioSectionVisible) {
                binding.linearRatio.visibility = View.VISIBLE
                binding.linearLayout.visibility = View.GONE
                binding.linearMargin.visibility = View.GONE
                binding.linearBorder.visibility = View.GONE

                underlineText(binding.textRatio)
                resetUnderline(binding.textLayout, binding.textMargin, binding.textBorder)

                isRatioSectionVisible = true
                isLayoutSectionVisible = false
                isMarginSectionVisible = false
                isBorderSectionVisible = false
            }
        }

        binding.textLayout.setOnClickListener {
            if (!isLayoutSectionVisible) {
                binding.linearLayout.visibility = View.VISIBLE
                binding.linearMargin.visibility = View.GONE
                binding.linearBorder.visibility = View.GONE
                binding.linearRatio.visibility = View.GONE

                underlineText(binding.textLayout)
                resetUnderline(binding.textRatio, binding.textMargin, binding.textBorder)

                isLayoutSectionVisible = true
                isMarginSectionVisible = false
                isBorderSectionVisible = false
                isRatioSectionVisible = false
            }
        }

        binding.textMargin.setOnClickListener {
            if (!isMarginSectionVisible) {
                binding.linearMargin.visibility = View.VISIBLE
                binding.linearBorder.visibility = View.GONE
                binding.linearRatio.visibility = View.GONE
                binding.linearLayout.visibility = View.GONE

                underlineText(binding.textMargin)
                resetUnderline(binding.textRatio, binding.textLayout, binding.textBorder)

                isMarginSectionVisible = true
                isBorderSectionVisible = false
                isRatioSectionVisible = false
                isLayoutSectionVisible = false
            }
        }

        binding.textBorder.setOnClickListener {
            if (!isBorderSectionVisible) {
                binding.linearBorder.visibility = View.VISIBLE
                binding.linearRatio.visibility = View.GONE
                binding.linearLayout.visibility = View.GONE
                binding.linearMargin.visibility = View.GONE

                underlineText(binding.textBorder)
                resetUnderline(binding.textRatio, binding.textLayout, binding.textMargin)

                isBorderSectionVisible = true
                isRatioSectionVisible = false
                isLayoutSectionVisible = false
                isMarginSectionVisible = false
            }
        }
    }

    private fun initView() {
        imageUris = intent.getStringArrayListExtra("imageUris") ?: arrayListOf()

        gridView = findViewById(R.id.gallery_grid)
        val adapter = ImageGridAdapter(this, imageUris)
        gridView.adapter = adapter
    }

    private fun underlineText(view: View) {
        if (view is TextView) {
            view.paintFlags = view.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            view.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }

    private fun resetUnderline(vararg views: TextView) {
        for (view in views) {
            view.paintFlags = view.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            view.setTextColor(ContextCompat.getColor(this, R.color.off_white))
        }
    }
}
