package com.example.photoeditor.beautycamera.collagemaker.Template_Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityTemplatesSavedImageBinding

class Templates_Saved_Image_Activity : AppCompatActivity() {

    lateinit var binding : ActivityTemplatesSavedImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplatesSavedImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {




    }
}