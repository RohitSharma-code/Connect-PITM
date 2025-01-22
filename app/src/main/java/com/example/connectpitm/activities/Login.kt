package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.connectpitm.R

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val quickView_btn : TextView = findViewById(R.id.signUp)
        quickView_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, signup::class.java)
            startActivity(intent) // Start SecondActivity

        }

    }
}