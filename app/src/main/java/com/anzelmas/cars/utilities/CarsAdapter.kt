package com.anzelmas.cars.utilities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anzelmas.cars.R
import com.anzelmas.cars.data.Car
import com.bumptech.glide.Glide

class CarsAdapter(private val cars: List<Car>) : RecyclerView.Adapter<CarsAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cars_list, parent, false)
        return CarViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {

        return holder.bind(cars[position])

//        holder.imageView.setImageResource(currentItem.imageView)
//        holder.textView.text = currentItem.textView
    }
}


class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val photo: ImageView = itemView.findViewById(R.id.car_ImageView)
    private val model: TextView = itemView.findViewById(R.id.modelName_TextView)
    private val numberPlate: TextView = itemView.findViewById(R.id.numberPlate_TextView)

    fun bind(car: Car) {
        Glide.with(itemView.context).load("https://").into(photo)
        model.text = "Model: " + car.model
        numberPlate.text = car.numberPlate
    }
}