package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.connectpitm.R
import com.example.connectpitm.quickView.quickView_dashboard

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quickView_btn : Button = findViewById(R.id.quickView_btn)
        quickView_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, quickView_dashboard::class.java)
            startActivity(intent) // Start SecondActivity

        }

        val login_btn : Button = findViewById(R.id.login_btn)
        login_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, login_As::class.java)
            startActivity(intent) // Start SecondActivity

        }




    }
}