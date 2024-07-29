package com.example.photoeditor.beautycamera.collagemaker.Template_Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityTemplatesFrameBinding

class Templates_Frame_Activity : AppCompatActivity() {

    lateinit var binding: ActivityTemplatesFrameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplatesFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        binding.linearText.setOnClickListener {

            var intent = Intent(this, Templates_Text_Activity::class.java)
            startActivity(intent)

        }

        binding.linearFilter.setOnClickListener {

            var intent = Intent(this, Templates_Filter_Activity::class.java)
            startActivity(intent)

        }

        binding.linearStiker.setOnClickListener {

            var intent = Intent(this, Templates_Stiker_Activity::class.java)
            startActivity(intent)

        }



    }
}