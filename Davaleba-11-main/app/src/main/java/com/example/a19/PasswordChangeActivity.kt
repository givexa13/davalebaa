package com.example.a19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var passwordInput: EditText
    private lateinit var approveButton: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        mAuth= FirebaseAuth.getInstance()

        passwordInput=findViewById(R.id.editTextTextPassword2)
        approveButton=findViewById(R.id.changePasswordButton)
         approveButton.setOnClickListener{
             val newPassword=passwordInput.text.toString()
             if (newPassword.isEmpty()) {
                 Toast.makeText(this, "ცარიელია ბიჯო!", Toast.LENGTH_SHORT).show()
             }else {
                 mAuth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener{task ->
                 if (task.isSuccessful) {
                     startActivity(Intent(this,FeedActivity::class.java))
                     finish()
                 }else{
                     Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show()
                 }

                 }
             }
         }
    }
}