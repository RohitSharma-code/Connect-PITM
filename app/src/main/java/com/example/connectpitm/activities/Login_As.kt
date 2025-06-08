package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connectpitm.R
import com.example.connectpitm.databinding.ActivityLoginAsBinding
import com.example.connectpitm.faculty.Faculty_Login
import kotlin.jvm.java

class login_As : AppCompatActivity() {
    lateinit var binding: ActivityLoginAsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_as)
        val studentBtn: Button = findViewById(R.id.studentButton)
        val facultyBtn: Button = findViewById(R.id.facultyButton)
        studentBtn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, login::class.java)
            startActivity(intent) // Start SecondActivity
        }
        facultyBtn.setOnClickListener {
            val i = Intent(this, Faculty_Login::class.java)
            startActivity(i)
        }
    }
}