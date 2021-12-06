package com.example.n5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResgisterActivity : AppCompatActivity() {
    private lateinit var editTextEmailAddress : EditText
    private lateinit var editTextTextPassword : EditText
    private lateinit var button2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resgister)
        init()
    }

    private fun init(){
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        button2 = findViewById(R.id.button2)
    }
    private fun registerListeners(){
        button2.setOnClickListener{
            val email = editTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this,"Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()

                    }
                }
        }
    }

}