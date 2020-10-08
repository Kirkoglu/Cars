package com.anzelmas.cars

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anzelmas.cars.utilities.MainActivity
import kotlinx.android.synthetic.main.cars_list.view.*

class CarAdapter(private val carList: MainActivity) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.car_ImageView
        val textView: TextView = itemView.carName_TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.cars_list,
            parent, false
        )

        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = carList[position]

        holder.imageView.setImageResource(currentItem.imageView)
        holder.textView.text = currentItem.textView


    }

    override fun getItemCount(): Int = carList.size

}