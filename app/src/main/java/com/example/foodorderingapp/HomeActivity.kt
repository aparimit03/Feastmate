package com.example.foodorderingapp

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodorderingapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding : ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivNotification.setOnClickListener{
            Toast.makeText(this,"This feature will be available soon",Toast.LENGTH_SHORT).show()
        }

        val navController = findNavController(R.id.fragmentHolderHomeScreen)
        binding.bottomNavView.setupWithNavController(navController)
    }
}