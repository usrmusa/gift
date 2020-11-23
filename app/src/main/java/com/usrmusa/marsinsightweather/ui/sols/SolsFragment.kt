package com.usrmusa.marsinsightweather.ui.sols

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.usrmusa.marsinsightweather.R
import com.usrmusa.marsinsightweather.databinding.SolsFragmentBinding
import com.usrmusa.marsinsightweather.utils.Resource
import com.usrmusa.marsinsightweather.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SolsFragment : Fragment(), SolsAdapter.SolItemListener {

    private var binding: SolsFragmentBinding by autoCleared()
    private val viewModel: SolsViewModel by viewModels()
    private lateinit var adapter: SolsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SolsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = SolsAdapter(this)
        binding.solsRv.layoutManager = LinearLayoutManager(requireContext())
        binding.solsRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.sols.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (true) adapter.setItems((it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedSol(solId: Int) {
        findNavController().navigate(
            R.id.action_solsFragment_to_solDetailFragment,
            bundleOf("id" to solId)
        )
    }
}