package com.example.foodorderingapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorderingapp.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashScreenBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = FirebaseAuth.getInstance()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (auth.currentUser == null){
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    startActivity(Intent(this, LoginSignupActivity::class.java))
                    finish()
                },3000)
        }
        else{
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    startActivity(Intent(this, LocationActivity::class.java))
                    finish()
                },3000)
        }
    }
}