package com.example.photoeditor.beautycamera.collagemaker.Collage_Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityCollageImageBackgroundBinding

class Collage_Image_Background_Activity : AppCompatActivity() {

    lateinit var binding : ActivityCollageImageBackgroundBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCollageImageBackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {



    }
}