package com.usrmusa.marsinsightweather.ui.sols

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.usrmusa.marsinsightweather.data.entities.Forecast
import com.usrmusa.marsinsightweather.databinding.ItemSolBinding


class SolsAdapter(private val listener: SolItemListener) :
    RecyclerView.Adapter<SolViewHolder>() {

    interface SolItemListener {
        fun onClickedSol(solId: Int)
    }

    private val items = ArrayList<Forecast>()

    fun setItems(items: List<Forecast>?) {
        this.items.clear()
        if (items != null) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolViewHolder {
        val binding: ItemSolBinding =
            ItemSolBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return SolViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SolViewHolder, position: Int) {
        holder.bind(items[position])
    }



}


class SolViewHolder(
    private val itemBinding: ItemSolBinding,
    private val listener: SolsAdapter.SolItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var forecast: Forecast

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Forecast) {
        this.forecast = item
        itemBinding.date.text = item.date
        itemBinding.tempAndHumanity.text = """${item.temp} - ${item.humidity}"""
        Glide.with(itemBinding.root)
            .load("item.image")
            .transform(CircleCrop())
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedSol(forecast.id)
    }
}