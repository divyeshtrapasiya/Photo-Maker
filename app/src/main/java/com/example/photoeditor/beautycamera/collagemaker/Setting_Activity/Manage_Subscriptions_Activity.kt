package com.example.photoeditor.beautycamera.collagemaker.Setting_Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.Activity.HomePageActivity
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityManageSubscriptionsBinding

class Manage_Subscriptions_Activity : AppCompatActivity() {

    lateinit var binding: ActivityManageSubscriptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageSubscriptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        binding.btnBack.setOnClickListener {

            var intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}