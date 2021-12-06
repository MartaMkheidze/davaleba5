package com.example.n5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var buttonpasswordchange : Button
    private lateinit var buttonlongout : Button
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerListeners()
        textView.text = FirebaseAuth.getInstance().currentUser?.uid
    }
    private fun init(){
        buttonpasswordchange = findViewById(R.id.buttonpasswordchange)
        buttonlongout = findViewById(R.id.buttonlongout)
        textView = findViewById(R.id.textView)
    }
    private fun registerListeners(){
        buttonlongout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
        buttonpasswordchange.setOnClickListener{
            startActivity(Intent(this,PasswordChangeActivity::class.java))
        }
    }
}