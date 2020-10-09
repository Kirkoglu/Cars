package com.anzelmas.cars.utilities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anzelmas.cars.R
import com.anzelmas.cars.data.PopularCars
import com.anzelmas.cars.data.ServiceBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            ServiceBuilder.buildService().getAvailableCars(WEB_SERVICE_URL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response -> onResponse(response) }, { t -> onFailure(t) }))
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: PopularCars) {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CarsAdapter(response.cars)
        }
    }
}

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