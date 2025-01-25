package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.connectpitm.R
import com.example.connectpitm.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.signUp.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, signup::class.java)
            startActivity(intent) // Start SecondActivity
        }

        binding.logInButton.setOnClickListener() {
            val emailBoxET = binding.emailBox.text.toString()
            val passwordBoxET = binding.passwordBox.text.toString()
            if (emailBoxET.isNotEmpty() && passwordBoxET.isNotEmpty()
            ) {
                if (emailBoxET.contains("@gmail.com") || emailBoxET.contains("@outlook.com") || emailBoxET.contains("@yahoo.com")
                ) {
                    val intent = Intent(this, otp_Verification::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Enter valid email ID", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@login, "Please field the inputs!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isValidPassword(password: String): Boolean {
        //(?=.*[a-z]) → at least one lowercase
        //(?=.*[A-Z]) → at least one uppercase
        //(?=.*\d) → at least one digit
        //(?=.*[@#$%^&+=!]) → at least one special character
        //.{8,64} → length between 8 and 64 characters
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{8,64}$")
        return password.matches(passwordPattern)
    }
}
