package com.usrmusa.marsinsightweather.ui.soldetail

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.usrmusa.marsinsightweather.R
import com.usrmusa.marsinsightweather.data.entities.Sol
import com.usrmusa.marsinsightweather.databinding.SolDetailFragmentBinding
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
        binding = SolDetailFragmentBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        //setupObservers()
    }

    private fun setupObservers() {
        TODO("Not yet implemented")
        //viewModel.character.observe(viewLifecycleOwner, Observer {
        //            when (it.status) {
        //                Resource.Status.SUCCESS -> {
        //                    bindCharacter(it.data!!)
        //                    binding.progressBar.visibility = View.GONE
        //                    binding.characterCl.visibility = View.VISIBLE
        //                }
        //
        //                Resource.Status.ERROR ->
        //                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
        //
        //                Resource.Status.LOADING -> {
        //                    binding.progressBar.visibility = View.VISIBLE
        //                    binding.characterCl.visibility = View.GONE
        //                }
        //            }
        //        })
    }

    @SuppressLint("SetTextI18n")
    private fun bindSol(sol: Sol) {
        binding.date.text = "Nov. 14"
        binding.max.text = sol.First_UTC
        binding.min.text = sol.Last_UTC
        binding.wind.text = sol.Season
        binding.direction.text = "North West"
        binding.pressure.text = 583.toString()
    }

}