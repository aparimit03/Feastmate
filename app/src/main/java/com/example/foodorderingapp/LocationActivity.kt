package com.example.foodorderingapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.R
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorderingapp.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {

    private val binding: ActivityLocationBinding by lazy {
        ActivityLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val arrayOfCities = arrayOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Pune", "Jaipur")
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,arrayOfCities)
        binding.locationDropdown.setAdapter(adapter)

        binding.locationDropdown.setOnItemClickListener { parent, view, position, id ->
            var selectedLocation = parent.getItemAtPosition(position).toString()
            Toast.makeText(this,"Selected City : $selectedLocation",Toast.LENGTH_SHORT).show()
        }
    }
}