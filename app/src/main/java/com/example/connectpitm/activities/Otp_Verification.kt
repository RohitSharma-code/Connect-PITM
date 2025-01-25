package com.example.connectpitm.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.connectpitm.R
import com.example.connectpitm.databinding.ActivityOtpVerificationBinding

class otp_Verification : AppCompatActivity() {
    lateinit var binding: ActivityOtpVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp_verification)
        val verifyOtp_btn: Button = findViewById(R.id.verifyOtp_btn)
        verifyOtp_btn.setOnClickListener {
            // Explicit Intent to navigate to SecondActivity
            val intent = Intent(this, student_dashboard::class.java)
            startActivity(intent) // Start SecondActivity
        }
        setOtpInputListener()
    }
    private fun setOtpInputListener(){
        binding.apply {
            box1.addTextChangedListener(otpTextWatcher(box1, box2, null))
            box2.addTextChangedListener(otpTextWatcher(box2, box3, box1))
            box3.addTextChangedListener(otpTextWatcher(box3, box4, box2))
            box4.addTextChangedListener(otpTextWatcher(box4, box5, box3))
            box5.addTextChangedListener(otpTextWatcher(box5, box6, box4))
            box6.addTextChangedListener(otpTextWatcher(box6, null, box5))
        }
    }
}

class otpTextWatcher(private val currentEditText: EditText, private val nextEditText: EditText?, private val previousEditText: EditText?): TextWatcher, View.OnKeyListener{
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