package com.example.photoeditor.beautycamera.collagemaker.Freesytle_Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFreestyleStikerBinding

class Freestyle_Stiker_Activity : AppCompatActivity() {

    lateinit var binding : ActivityFreestyleStikerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFreestyleStikerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {



    }
}