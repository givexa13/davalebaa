package com.example.a19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var resetEmailInput: EditText
    private lateinit var resetPasswordButton: Button
    lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        mAuth= FirebaseAuth.getInstance()
        resetEmailInput=findViewById(R.id.emailForReset)
        resetPasswordButton=findViewById(R.id.passwordResetButton)

        resetPasswordButton.setOnClickListener{
            val email=resetEmailInput.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener {task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show()

                    }

                }
            }
        }


    }
}