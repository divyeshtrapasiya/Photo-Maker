package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleDrowBinding

class Freestyle_Drow_Activity : AppCompatActivity() {

    lateinit var binding : ActivityFreestyleDrowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleDrowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

    }

}