package com.anythum.grocerydelivery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.anythum.grocerydelivery.ui.HomeActivity

class GroceryActivity : AppCompatActivity() {
    lateinit var groceryViewModel: GroceryVierModel
    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(
            applicationContext,
            "App Started",
            Toast.LENGTH_LONG
        ).show()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        groceryViewModel = ViewModelProvider(this).get(GroceryVierModel::class.java)
        //val otpSent = groceryViewModel.otpSent
        var otpSent: Boolean = false
        val etPhoneNumber = findViewById<EditText>(R.id.etPhone)
        val etOtp = findViewById<EditText>(R.id.etOtp)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnGetOtp = findViewById<Button>(R.id.btn_getOtp)

        btnGetOtp.setOnClickListener {

            val phone =
                etPhoneNumber.text.toString().trim()


            if (phone.length != 10) {

                Toast.makeText(
                    this,
                    "Enter valid phone number",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("PHONE", "Invalid Phone Number")

            } else {

                otpSent = true

                Toast.makeText(
                    this,
                    "OTP Sent",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("OTP", "OTP Button Clicked")
            }
        }

        btnLogin.setOnClickListener {

            val otp =
                etOtp.text.toString().trim()


            if (!otpSent) {

                Toast.makeText(
                    this,
                    "Please Get OTP First",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("LOGIN", "OTP Not Sent")
            }
            else if (otp == "1234") {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("LOGIN", "Correct OTP")

                val intent =
                    Intent(this, HomeActivity::class.java)

                startActivity(intent)

                finish()
            }


            else {

                Toast.makeText(
                    this,
                    "Wrong OTP",
                    Toast.LENGTH_SHORT
                ).show()

                Log.d("LOGIN", "Wrong OTP")
            }
        }
    }
}