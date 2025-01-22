package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.connectpitm.R

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        val signUp_btn : Button = findViewById(R.id.signup_btn)
        signUp_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, otp_Verification::class.java)
            startActivity(intent) // Start SecondActivity
        }
    }
}