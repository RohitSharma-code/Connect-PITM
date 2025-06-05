package com.example.connectpitm.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.connectpitm.R
import com.example.connectpitm.activities.Registration_Successful
import com.example.connectpitm.databinding.ActivitySignupBinding
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.showAlignTop

class signup : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        binding.signUpBtn.setOnClickListener {
            validateFields() //validate the conditions
        }
        setUpDrawableClickListener() //Calling the EndDrawable click function
        dropDown() //Calling the dropDown function

        binding.login.setOnClickListener {
            val intent = Intent(this, login::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

    }

    //For DropDown semester list
    fun dropDown() {
        // get reference to the string array that we just created
        val semester = resources.getStringArray(R.array.semester)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, semester)
        // get reference to the autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)
    }


    //setting the attributes of all edit text in separate function
    fun setUpDrawableClickListener() {
        setEndDrawableClickListener(binding.clgRollNoBox, R.string.clgRollNo)
        setEndDrawableClickListener(binding.emailBox, R.string.emailId)
        setEndDrawableClickListener(binding.passwordBox, R.string.passwordCriteria)
    }

    //Email Checking
    fun isValidEmail(email: String): Boolean {
        val test =
            email.contains("@gmail.com") || email.contains("@outlook.com") || email.contains("@yahoo.com")
        return test
    }

    //Password Checking
    fun isValidPassword(password: String): Boolean {
        //(?=.*[a-z]) → at least one lowercase
        //(?=.*[A-Z]) → at least one uppercase
        //(?=.*\d) → at least one digit
        //(?=.*[@#$%^&+=!]) → at least one special character
        //.{8,64} → length between 8 and 64 characters
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{8,64}$")
        return password.matches(passwordPattern)
    }

    fun tenDigitRollNo(rollNo: String): Boolean{
        val tenDigit = Regex(".{10}$")
        return rollNo.matches(tenDigit)
    }
    //Creating the popupWindow like balloon
    @SuppressLint("SuspiciousIndentation")
    fun createBalloon(
        context: Context,
        text: Int,
        view: View
    ) {

        val balloon = Balloon.Builder(context)
            .setWidthRatio(1.0f)
            .setHeight(BalloonSizeSpec.WRAP)
            .setTextResource(text)
            .setTextColorResource(R.color.white)
            .setTextSize(15f)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowSize(10)
            .setArrowPosition(0.94f)
            .setPadding(12)
            .setCornerRadius(8f)
            .setArrowColorResource(R.color.blue1)
            .setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.rounded_button))
            .setBalloonAnimation(BalloonAnimation.ELASTIC)
            .setLifecycleOwner(this)
            .build()

            // Show balloon above EditText
            view.showAlignTop(balloon)

            // Dismiss after short time
            balloon.dismissWithDelay(2000)

    }

    //All validation of Edit text and set exclamation in endDrawable
    fun validateFields() {
        val clgRollNo = binding.clgRollNoBox.text.toString()
        val email = binding.emailBox.text.toString()
        val password = binding.passwordBox.text.toString()
        val dropDown = binding.autoCompleteTextView.text.toString()

        //Accessing the drawable file
        val drawable = ContextCompat.getDrawable(this, R.drawable.exclamation_mark)

        //Reset it first
        binding.clgRollNoBox.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        binding.emailBox.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
        binding.passwordBox.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)


        //Switch case
        when {
            clgRollNo.isEmpty() || !tenDigitRollNo(clgRollNo) -> {
                binding.clgRollNoBox.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
                createBalloon(
                    this, R.string.clgRollNo,
                    binding.clgRollNoBox
                )
                return
            }

            dropDown.isEmpty() -> {
                Toast.makeText(this, "Please select the semester", Toast.LENGTH_SHORT).show()

            }

            email.isEmpty() || !isValidEmail(email) -> {
                binding.emailBox.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
                createBalloon(
                    this,
                    R.string.emailId,
                    binding.emailBox
                )
                return
            }

            password.isEmpty() || !isValidPassword(password) -> {
                binding.passwordBox.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null)
                createBalloon(
                    this, R.string.passwordCriteria,
                    binding.passwordBox
                )
                return
            }

            else -> {
                if (clgRollNo.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && dropDown.isNotEmpty()) {
                    val intent = Intent(this, Registration_Successful::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent) // Start SecondActivity

                }
            }
        }
    }

    //click listener of exclamation mark after detecting the second position of edit text
    @SuppressLint("ClickableViewAccessibility")
    fun setEndDrawableClickListener(view: View, textResId: Int) {
        view.setOnTouchListener { v, event ->
            if (v !is AppCompatEditText) {
                return@setOnTouchListener false
            }
            val drawableEnd =
                v.compoundDrawables[2]
                    ?: return@setOnTouchListener false// index 2 is END
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableStartX = v.width - v.paddingEnd - drawableEnd.bounds.width()
                if (event.x >= drawableStartX) {
                    createBalloon(this, textResId, v)
                    return@setOnTouchListener true
                }
            }
            false
        }
    }
}

