package com.example.n5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var editTextNewPassword : EditText
    private lateinit var buttonchangepassword : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
        init()
        registerListeners()
    }
    private fun init(){
        editTextNewPassword = findViewById(R.id.editTextNewPassword)
        buttonchangepassword = findViewById(R.id.buttonchangepassword)
    }
    private fun registerListeners(){
        buttonchangepassword.setOnClickListener{
            val newPassword = editTextNewPassword.text.toString()
            if (newPassword.isEmpty()||newPassword.length<9){
                Toast.makeText(this,"Incorect password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this,"SUCCESS",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
                } }
        }
    }
}