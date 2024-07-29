package com.example.photoeditor.beautycamera.collagemaker.Setting_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityTermsOfUseBinding

class Terms_of_Use_Activity : AppCompatActivity() {

    lateinit var binding: ActivityTermsOfUseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsOfUseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


        binding.ivBack.setOnClickListener {

            onBackPressed()

        }




    }
}