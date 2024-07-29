package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditImageEditBinding

class Edit_Image_Edit_Activity : AppCompatActivity() {

    lateinit var binding : ActivityEditImageEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditImageEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {




    }
}