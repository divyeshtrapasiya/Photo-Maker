package com.example.photoeditor.beautycamera.collagemaker.Setting_Activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.photoeditor.beautycamera.collagemaker.Activity.HomePageActivity
import com.example.photoeditor.beautycamera.collagemaker.R
import com.example.photoeditor.beautycamera.collagemaker.databinding.ActivitySettingBinding

class Setting_Activity : AppCompatActivity() {

    lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {
        binding.backButton.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }

        binding.textLanguages.setOnClickListener {
            val intent = Intent(this, Language_Activity::class.java)
            startActivity(intent)
        }

        binding.imageLanguageArrow.setOnClickListener {
            val intent = Intent(this, Language_Activity::class.java)
            startActivity(intent)
        }

        binding.manageSubscription.setOnClickListener {
            val intent = Intent(this, Manage_Subscriptions_Activity::class.java)
            startActivity(intent)
        }

        binding.privacyPolicy.setOnClickListener {
            val intent = Intent(this, Privacy_Policy_Activity::class.java)
            startActivity(intent)
        }

        binding.termsOfUse.setOnClickListener {
            val intent = Intent(this, Terms_of_Use_Activity::class.java)
            startActivity(intent)
        }

        binding.FeedbackEmail.setOnClickListener {
            showFeedbackDialog()
        }

        binding.resolution.setOnClickListener {
            showResolutionDialog()
        }
    }

    private fun showResolutionDialog() {
        val dialog = Dialog(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_resolution, null)

        val radioGroup = dialogView.findViewById<RadioGroup>(R.id.radioGroupResolution)
        val radioHigh = dialogView.findViewById<RadioButton>(R.id.radio_high)
        val radioRegular = dialogView.findViewById<RadioButton>(R.id.radio_regular)

        // Set default checked state
        radioRegular.isChecked = true

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_high -> {
                    // Handle high resolution selection
                }
                R.id.radio_regular -> {
                    // Handle regular resolution selection
                }
            }
        }

//        val buttonSetResolution = dialogView.findViewById<Button>(R.id.button_set_resolution)
//        buttonSetResolution.setOnClickListener {
//            val selectedId = radioGroup.checkedRadioButtonId
//            when (selectedId) {
//                R.id.radio_high -> {
//                    // Set resolution to high
//                }
//                R.id.radio_regular -> {
//                    // Set resolution to medium
//                }
//            }
//        }
        dialog.dismiss()

        dialog.setContentView(dialogView)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }

    private fun showFeedbackDialog() {
        val dialog = Dialog(this)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_feedback, null)

        val No_thanks = dialogView.findViewById<TextView>(R.id.text_nothanks)
        val Send_Feedback = dialogView.findViewById<TextView>(R.id.text_send_feedback)

        No_thanks.setOnClickListener {
            dialog.dismiss()
        }

        Send_Feedback.setOnClickListener {
            val intent = Intent(this, Feedback_Email_Activity::class.java)
            startActivity(intent)
            finish()
        }

        dialog.setContentView(dialogView)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }
}
