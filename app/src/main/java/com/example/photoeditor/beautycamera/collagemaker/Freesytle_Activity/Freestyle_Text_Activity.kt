package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleTextBinding

class Freestyle_Text_Activity : AppCompatActivity() {

    lateinit var binding: ActivityFreestyleTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


    }
}