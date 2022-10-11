package com.eos_gnss.bellapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.eos_gnss.bellapp.data.Car
import com.eos_gnss.bellapp.R

class CarAdapter(
    private val context: Context
): RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    private val mutableList = mutableListOf<Car>()

    private val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_car_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mutableList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = mutableList.size

    fun setData(list: List<Car>) {
        mutableList.clear()
        mutableList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val carImageView: ImageView = itemView.findViewById(R.id.car_image_view)
        private val carModelTextView: AppCompatTextView = itemView.findViewById(R.id.car_model)
        private val carPriceTextView: AppCompatTextView = itemView.findViewById(R.id.car_price)
        private val carStarRating: AppCompatRatingBar = itemView.findViewById(R.id.car_rating_star)

        fun bind(model: Car) {
            carImageView.setImageResource(model.imageUrl)
            carModelTextView.text = model.model
            carPriceTextView.text = context.getString(R.string.car_price_label).format(model.marketPrice)
            carStarRating.rating = model.rating
        }

    }

}