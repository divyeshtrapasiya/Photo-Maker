package com.example.photoeditor.beautycamera.collagemaker.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.R

class Splash_Screen_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initview()

    }

    private fun initview() {

        Handler().postDelayed({
            val mainIntent = Intent(this, HomePageActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, 3000)

    }
}