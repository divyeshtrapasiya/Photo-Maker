package com.example.photoeditor.beautycamera.collagemaker.Edit_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityEditDrowBinding

class Edit_drow_Activity : AppCompatActivity() {

    lateinit var binding : ActivityEditDrowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditDrowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {




    }
}