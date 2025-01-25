package com.example.connectpitm.quickView

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.connectpitm.R

class department : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_department)

        val bba_CardView : CardView = findViewById(R.id.bba_CardView)
        bba_CardView.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, BBA::class.java)
            startActivity(intent) // Start SecondActivity

        }

        val bca_CardView : CardView = findViewById(R.id.bca_CardView)
        bca_CardView.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, BCA::class.java)
            startActivity(intent) // Start SecondActivity

        }
    }
}