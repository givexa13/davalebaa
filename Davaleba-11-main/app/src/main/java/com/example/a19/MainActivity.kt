package com.example.a19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var enterEmail: EditText
    private lateinit var enterPassword: EditText
    private lateinit var signInButton: Button
    private lateinit var registrationButton: Button
    private lateinit var resetButton: Button



    private lateinit var mAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enterEmail= findViewById(R.id.editTextEmail)
        enterPassword=findViewById(R.id.editTextTextPassword)
        signInButton=findViewById(R.id.signInButton)
        registrationButton=findViewById(R.id.registrationButton)
        resetButton=findViewById(R.id.forgotPassword)
        mAuth= FirebaseAuth.getInstance()

        signInButton.setOnClickListener {
            val email= enterEmail.text.toString()
            val password= enterPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ცარიელია", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {task ->
                if (task.isSuccessful){
                    startActivity(Intent(this,FeedActivity::class.java))
                    finish()
                }else {
                    Toast.makeText(this, "გაერორებს", Toast.LENGTH_SHORT).show()
                }

                }
            }
        }
        registrationButton.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))
        }

        resetButton.setOnClickListener {
            startActivity(Intent(this,ResetPasswordActivity::class.java))
        }



    }
}
