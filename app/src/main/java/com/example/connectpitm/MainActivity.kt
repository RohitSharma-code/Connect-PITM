package com.example.connectpitm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.connectpitm.R.anim.slide_out_right

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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