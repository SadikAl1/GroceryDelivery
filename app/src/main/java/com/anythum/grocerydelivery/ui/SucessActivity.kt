package com.anythum.grocerydelivery.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anythum.grocerydelivery.R
import com.google.android.material.button.MaterialButton

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sucess)

        val btnContinue =
            findViewById<MaterialButton>(R.id.btnContinue)

        btnContinue.setOnClickListener {

            val intent =
                Intent(this, HomeActivity::class.java)

            startActivity(intent)

            finish()
        }
    }
}