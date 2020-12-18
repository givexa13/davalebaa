package com.example.a19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class FeedActivity : AppCompatActivity() {

    private lateinit var pInfoTextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var logOutButton:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        mAuth= FirebaseAuth.getInstance()
        pInfoTextView=findViewById(R.id.textView)
        passwordChangeButton=findViewById(R.id.timeToChangePassword)
        logOutButton=findViewById(R.id.logOutMan)

        pInfoTextView.text=mAuth.currentUser?.uid
        passwordChangeButton.setOnClickListener{
            startActivity(Intent(this,PasswordChangeActivity::class.java))

        }
        logOutButton.setOnClickListener{
            mAuth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()


        }




    }
}