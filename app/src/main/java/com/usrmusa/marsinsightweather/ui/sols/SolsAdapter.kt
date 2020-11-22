package com.usrmusa.marsinsightweather.ui.sols

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.usrmusa.marsinsightweather.data.entities.Sol
import com.usrmusa.marsinsightweather.databinding.ItemSolBinding

class SolsAdapter(private val listener: SolItemListener) :
    RecyclerView.Adapter<SolViewHolder>() {

    interface SolItemListener {
        fun onClickedSol(solId: Int)
    }

    private val items = ArrayList<Sol>()

    fun setItems(items: ArrayList<Sol>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolViewHolder {
        val binding: ItemSolBinding =
            ItemSolBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SolViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: SolViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class SolViewHolder(
    private val itemBinding: ItemSolBinding,
    private val listener: SolsAdapter.SolItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var sol: Sol

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Sol) {
        this.sol = item
        itemBinding.date.text = "Nov. 14"
        itemBinding.maxAndMin.text = """${item.First_UTC} - ${item.Last_UTC}"""
        Glide.with(itemBinding.root)
            .load("https://raw.githubusercontent.com/usrmusa/data/main/avater.jpg")
            .transform(CircleCrop())
            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        listener.onClickedSol(sol.id)
    }
}