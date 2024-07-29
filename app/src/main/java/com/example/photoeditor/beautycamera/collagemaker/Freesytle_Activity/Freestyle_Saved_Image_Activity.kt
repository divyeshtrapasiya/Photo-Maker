package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleSavedImageBinding

class Freestyle_Saved_Image_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleSavedImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleSavedImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


    }
}