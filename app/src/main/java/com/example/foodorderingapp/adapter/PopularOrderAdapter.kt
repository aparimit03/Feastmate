package com.example.foodorderingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.data.PopularOrder
import com.example.foodorderingapp.databinding.ItemPopularOrderBinding

class PopularOrderAdapter(val popularOrder : Array<PopularOrder>) : RecyclerView.Adapter<PopularOrderAdapter.PopularOrderViewHolder>() {
    inner class PopularOrderViewHolder(binding: ItemPopularOrderBinding) : RecyclerView.ViewHolder(binding.root){
        val ivFoodImage = binding.ivFoodImage
        val tvFoodTitle = binding.tvFoodTitle
        val tvPrice = binding.tvPrice
        val btnAddToCart = binding.btnAddToCart
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularOrderViewHolder {
        val viewBinding = ItemPopularOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularOrderViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return popularOrder.size
    }

    override fun onBindViewHolder(holder: PopularOrderViewHolder, position: Int) {
        val currentOrderItem = popularOrder[position]
        holder.ivFoodImage.setImageResource(currentOrderItem.image)
        holder.tvFoodTitle.text = currentOrderItem.title
        holder.tvPrice.text = "₹ " + currentOrderItem.price.toString()
//        holder.btnAddToCart.setOnClickListener {
//            TODO("Add to Cart functionality")
//        }
    }
}