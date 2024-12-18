package com.example.foodorderingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorderingapp.databinding.ActivityLoginSignupBinding
import com.google.firebase.auth.FirebaseAuth

class LoginSignupActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var binding: ActivityLoginSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        binding = ActivityLoginSignupBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            loginUser(email, password)
        }

        binding.btnSignup.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            registerUser(email, password)
        }
    }
    fun registerUser(email : String, password : String){
        if(email.isBlank()){
            Toast.makeText(this,"Email is required",Toast.LENGTH_SHORT).show()
            return
        }
        if(password.isBlank()){
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show()
            return
        }
        if (password.length < 6){
            Toast.makeText(this,"Min password length is 6 character",Toast.LENGTH_SHORT).show()
            return
        }
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LocationActivity::class.java))
                    finish()
                }
                else {
                    Toast.makeText(this, "Registration failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    fun loginUser(email : String, password : String){
        if(email.isBlank()){
            Toast.makeText(this,"Email is required",Toast.LENGTH_SHORT).show()
            return
        }
        if(password.isBlank()){
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show()
            return
        }
        if (password.length < 6){
            Toast.makeText(this,"Min password length is 6 character",Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){task->
                if (task.isSuccessful){
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LocationActivity::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this, "Login failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }
}