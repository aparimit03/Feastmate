package com.example.foodorderingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val imageList = ArrayList<SlideModel>()
//        imageList.add(SlideModel(R.drawable.carousel_image_1))
//        imageList.add(SlideModel(R.drawable.carousel_image_2))
//        imageList.add(SlideModel(R.drawable.carousel_image_3))
//        imageList.add(SlideModel(R.drawable.carousel_image_4))
//        imageList.add(SlideModel(R.drawable.carousel_image_5))
//
//        binding.imageSlider.setImageList(imageList)
//
//        binding.imageSlider.startSliding(2000)
    }
}