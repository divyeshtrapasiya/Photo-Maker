package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditTextBinding

class Edit_Text_Activity : AppCompatActivity() {

    lateinit var binding: ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {




    }
}