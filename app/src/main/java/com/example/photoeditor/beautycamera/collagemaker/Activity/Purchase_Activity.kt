package com.example.photoeditor.beautycamera.collagemaker.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityPurchaseBinding

class Purchase_Activity : AppCompatActivity() {

    lateinit var binding: ActivityPurchaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()

    }

    private fun initview() {

        binding.closeButton.setOnClickListener {

            var intent = Intent(this,HomePageActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}