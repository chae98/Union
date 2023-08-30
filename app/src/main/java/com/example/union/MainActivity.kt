package com.example.union

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var email : String? = null
    var password : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // button
        var btn_findPassword = findViewById<Button>(R.id.btn_findPassword)
        var btn_singUp = findViewById<Button>(R.id.btn_signUp)
        var btn_logIn = findViewById<Button>(R.id.btn_logIn)


        // editText
        var edt_email = findViewById<EditText>(R.id.edt_email)
        var edt_password = findViewById<EditText>(R.id.edt_password)

        btn_findPassword.setOnClickListener{
            startActivity(Intent(this,findPassword::class.java))
        }

        btn_singUp.setOnClickListener{
            startActivity(Intent(this,signIn::class.java))
        }

        btn_logIn.setOnClickListener {
            email = edt_email.text.toString()
            password = edt_password.text.toString()
            Toast.makeText(this,email + " , " + password, Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainPage::class.java))
        }




    }






}