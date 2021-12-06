package com.example.n5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var editTextEmailAdd : EditText
    private lateinit var buttonsend : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)
    }
    private fun init(){
        editTextEmailAdd = findViewById(R.id.editTextEmailAdd)
        buttonsend = findViewById(R.id.buttonsend)
    }
    private fun registerListeners(){
        buttonsend.setOnClickListener{
            val email = editTextEmailAdd.text.toString()
            if (email.isEmpty()){
                Toast.makeText(this,"Enter email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task -> if (task.isSuccessful){
                    Toast.makeText(this,"Check email",Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                } }
        }
    }
}