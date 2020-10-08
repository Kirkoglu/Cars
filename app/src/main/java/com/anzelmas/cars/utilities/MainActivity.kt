package com.anzelmas.cars.utilities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anzelmas.cars.CarAdapter
import com.anzelmas.cars.R
import com.anzelmas.cars.data.Car
import com.anzelmas.cars.data.CarService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: CarAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerAdapter = CarAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = recyclerAdapter
        recycler_view.setHasFixedSize(true)
    }

    val carService = CarService.create().getCar()

    carService.enqueue(
    object : Callback<List<Car>> {
        override fun onResponse(call: Call<List<Car>>?, response: Response<List<Car>>?) {

            if (response?.body() != null)
                CarAdapter.setCarListItems(response.body()!!)
        }

        override fun onFailure(call: Call<List<Car>>?, t: Throwable?) {

        }
    })
//    private fun generateCarList(size: Int): List<CarItem> {
//        val list = ArrayList<CarItem>()
//        for (i in 0 until size) {
//            val drawable = when (i % 3) {
//                0 -> R.drawable.ic_nissanleaf
//                1 -> R.drawable.ic_volkswageneup
//                else -> R.drawable.ic_baseline_directions_car_24
//            }
//            val item = CarItem(drawable, "Item $i")
//            list += item
//        }
//        return list
//    }
}