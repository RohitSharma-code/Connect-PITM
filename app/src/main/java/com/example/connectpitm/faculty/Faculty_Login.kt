package com.example.connectpitm.faculty

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connectpitm.R
import com.example.connectpitm.activities.otp_Verification
import com.example.connectpitm.databinding.ActivityFacultyLoginBinding
import kotlin.jvm.java

class Faculty_Login : AppCompatActivity() {
    lateinit var binding: ActivityFacultyLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_faculty_login)

        binding.signUpFaculty.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, Faculty_signup::class.java)
            startActivity(intent) // Start SecondActivity
        }

        binding.logInButtonFaculty.setOnClickListener() {
            val emailBoxET = binding.emailBox.text.toString()
            val passwordBoxET = binding.passwordBox.text.toString()
            if (emailBoxET.isNotEmpty() && passwordBoxET.isNotEmpty()
            ) {
                if (emailBoxET.contains("@gmail.com") || emailBoxET.contains("@outlook.com") || emailBoxET.contains("@yahoo.com")
                ) {
                    val intent = Intent(this, Faculty_Dashboard::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Enter valid email ID", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@Faculty_Login, "Please field the inputs!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
