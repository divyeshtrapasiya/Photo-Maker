package com.example.photoeditor.beautycamera.collagemaker.Setting_Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityFeedbackEmailBinding

class Feedback_Email_Activity : AppCompatActivity() {

    lateinit var binding : ActivityFeedbackEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {


        binding.ivBack.setOnClickListener {

            val intent = Intent(this, Setting_Activity::class.java)
            startActivity(intent)
            finish()

        }



    }
}