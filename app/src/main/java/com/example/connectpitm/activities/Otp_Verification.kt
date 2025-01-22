package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.connectpitm.R

class otp_Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otp_verification)
        val verifyOtp_btn: Button = findViewById(R.id.verifyOtp_btn)
        verifyOtp_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, student_dashboard::class.java)
            startActivity(intent) // Start SecondActivity
        }
    }
}