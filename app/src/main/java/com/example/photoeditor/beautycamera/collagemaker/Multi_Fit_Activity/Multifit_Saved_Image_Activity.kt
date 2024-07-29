package com.example.photoeditor.beautycamera.collagemaker.Multi_Fit_Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivityMultifitSavedImageBinding

class Multifit_Saved_Image_Activity : AppCompatActivity() {

    lateinit var binding : ActivityMultifitSavedImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_multifit_saved_image)
    }
}