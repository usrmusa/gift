package com.usrmusa.marsinsightweather.ui.soldetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.usrmusa.marsinsightweather.data.entities.Forecast
import com.usrmusa.marsinsightweather.databinding.SolDetailFragmentBinding
import com.usrmusa.marsinsightweather.utils.Resource
import com.usrmusa.marsinsightweather.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SolDetailFragment : Fragment() {

    private var binding: SolDetailFragmentBinding by autoCleared()
    private val viewModel: SolDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SolDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.solDetails.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindSol(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.solCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.solCl.visibility = View.GONE
                }
            }
        })
    }

    private fun bindSol(forecast: Forecast) {
        binding.date.text = forecast.date
        binding.max.text = forecast.temp.toString()
        binding.max.text = forecast.humidity.toString()
        binding.wind.text = forecast.windSpeed.toString()
        binding.direction.text = forecast.safe.toString()
        Glide.with(binding.root)
            .load("solDetails.image")
            .transform(CircleCrop())
            .into(binding.image)
    }
}