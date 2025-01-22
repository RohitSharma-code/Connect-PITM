package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.connectpitm.R

class login_As : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_as)
        val quickView_btn : Button = findViewById(R.id.studentButton)
        quickView_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, login::class.java)
            startActivity(intent) // Start SecondActivity
        }

    }
}