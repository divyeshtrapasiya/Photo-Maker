package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditSavedImageBinding

class Edit_Saved_Image_Activity : AppCompatActivity() {

    lateinit var binding: ActivityEditSavedImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditSavedImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


    }
}