package com.example.connectpitm.faculty

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connectpitm.R
import com.example.connectpitm.databinding.ActivityFacultyOtpVerficationBinding

class Faculty_Otp_Verfication : AppCompatActivity() {
    lateinit var binding: ActivityFacultyOtpVerficationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_faculty_otp_verfication)

        val verifyOtp_btn: Button = findViewById(R.id.verifyOtp_btn_faculty)
        verifyOtp_btn.setOnClickListener {
            val otp1 = binding.box1.text.toString().trim()
            val otp2 = binding.box2.text.toString().trim()
            val otp3 = binding.box3.text.toString().trim()
            val otp4 = binding.box4.text.toString().trim()
            val otp5 = binding.box5.text.toString().trim()
            val otp6 = binding.box6.text.toString().trim()
            // Explicit Intent to navigate to SecondActivity
            if (otp1.isNotEmpty() && otp2.isNotEmpty() && otp3.isNotEmpty() && otp4.isNotEmpty() && otp5.isNotEmpty() && otp6.isNotEmpty()){
                val intent = Intent(this, Faculty_Registration_Successful::class.java)
                startActivity(intent) // Start SecondActivity
            }
            else{
                Toast.makeText(this, "Fill the otp!", Toast.LENGTH_SHORT).show()
            }

        }
        setOtpInputListener()
    }
    private fun setOtpInputListener(){
        binding.apply {
            box1.addTextChangedListener(otpTextWatcher_Faculty(box1, box2, null))
            box2.addTextChangedListener(otpTextWatcher_Faculty(box2, box3, box1))
            box3.addTextChangedListener(otpTextWatcher_Faculty(box3, box4, box2))
            box4.addTextChangedListener(otpTextWatcher_Faculty(box4, box5, box3))
            box5.addTextChangedListener(otpTextWatcher_Faculty(box5, box6, box4))
            box6.addTextChangedListener(otpTextWatcher_Faculty(box6, null, box5))
        }
    }

}


class otpTextWatcher_Faculty(private val currentEditText: EditText, private val nextEditText: EditText?, private val previousEditText: EditText?): TextWatcher, View.OnKeyListener{
    init {
        currentEditText.setOnKeyListener(this)
    }
    override fun beforeTextChanged(
        s: CharSequence?,
        start: Int,
        count: Int,
        after: Int
    ) {
    }

    override fun onTextChanged(
        s: CharSequence?,
        start: Int,
        before: Int,
        count: Int
    ) {
    }

    override fun afterTextChanged(s: Editable?) {
        if (s?.length == 1){
            nextEditText?.requestFocus()
        }
    }

    override fun onKey(
        v: View?,
        keyCode: Int,
        event: KeyEvent?
    ): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL && event?.action == KeyEvent.ACTION_DOWN && currentEditText.text.isEmpty()){
            previousEditText?.requestFocus()
            return true
        }
        return false
    }

}