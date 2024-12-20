package com.example.foodorderingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.carousel.auna.interfaces.ItemClickListener
import com.carousel.auna.models.SlideModel
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.PopularOrderAdapter
import com.example.foodorderingapp.data.PopularOrder
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

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.carousel_image_1))
        imageList.add(SlideModel(R.drawable.carousel_image_2))
        imageList.add(SlideModel(R.drawable.carousel_image_3))
        imageList.add(SlideModel(R.drawable.carousel_image_4))
        imageList.add(SlideModel(R.drawable.carousel_image_5))

        binding.imageSlider.setImageList(imageList)
        binding.imageSlider.startSliding(2000)

//        binding.imageSlider.setItemClickListener(object: ItemClickListener {
//            override fun onItemSelected(position: Int){
//                if(position ==0){
//                    Toast.makeText(context,"this is toast message 1", Toast.LENGTH_SHORT).show()
//                }else if(position == 1){
//                    Toast.makeText(context,"this is toast message 2", Toast.LENGTH_SHORT).show()
//                }else if(position == 2){
//                    Toast.makeText(context,"this is toast message 3", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })

        val popularOrders : Array<PopularOrder> = arrayOf(
            PopularOrder(1, "Burger", R.drawable.food_item_burger, 40),
            PopularOrder(2, "Fries", R.drawable.food_item_fries, 50),
            PopularOrder(3, "Pasta", R.drawable.food_item_pasta, 70),
            PopularOrder(4, "Pizza", R.drawable.food_item_pizza, 90)
        )

        val adapter = PopularOrderAdapter(popularOrders)
        binding.rvPopularOrder.adapter = adapter
        binding.rvPopularOrder.layoutManager = LinearLayoutManager(requireContext())
    }
}