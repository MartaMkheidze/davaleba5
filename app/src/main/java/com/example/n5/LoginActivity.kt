package com.example.n5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var button : Button
    private lateinit var buttonreg : Button
    private lateinit var buttonreset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerListener()
    }

    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        button = findViewById(R.id.button)
        buttonreg = findViewById(R.id.buttonreg)
        buttonreset = findViewById(R.id.buttonreset)
    }

    private fun registerListener(){
        buttonreg.setOnClickListener{
            val intent = Intent(this,ResgisterActivity::class.java)
            startActivity(intent)
        }
        buttonreset.setOnClickListener{
            val intent = Intent(this,PasswordResetActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener(){
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty()|| password.isEmpty()){
                Toast.makeText(this,"Empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        gotoProfile()
                    }else{
                        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

    private fun gotoProfile(){
        startActivity(Intent(this,ProfileActivity::class.java))
        finish()
    }

}