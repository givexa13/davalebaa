package com.example.a19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var signUpEmailEditText: EditText
    private lateinit var signUpPasswordEditText: EditText
    private lateinit var registerButton: Button

    private lateinit var mAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth= FirebaseAuth.getInstance()

        if (mAuth.currentUser!=null) {
            startActivity(Intent(this,FeedActivity::class.java))
            finish()
        }

        setContentView(R.layout.activity_registration)

        signUpEmailEditText=findViewById(R.id.signUpEmail)
        signUpPasswordEditText=findViewById(R.id.signUpPassword)
        registerButton=findViewById(R.id.SignUpButton)



        registerButton.setOnClickListener {
            val email =signUpEmailEditText.text.toString()
            val password=signUpPasswordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ცარიელია!", Toast.LENGTH_SHORT).show()
            }else {
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task->

                    if (task.isSuccessful) {
                                startActivity(Intent(this,MainActivity::class.java))

                    } else {
                        Toast.makeText(this, "ერორია ერორიი", Toast.LENGTH_SHORT).show()
                            }
                }

            }
        }
    }
}