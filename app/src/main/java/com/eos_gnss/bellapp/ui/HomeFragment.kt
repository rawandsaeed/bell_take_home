package com.eos_gnss.bellapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eos_gnss.bellapp.R
import com.eos_gnss.bellapp.base.BaseFragment
import com.eos_gnss.bellapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var adapter: CarAdapter

    private val viewModel: HomeViewModel by viewModel()

    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun initViews() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = linearLayoutManager
        adapter = CarAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                context?.getDrawable(R.drawable.divider)?.let { setDrawable(it) }
            }
        )
    }

    override fun initObservers() {
        with(viewModel) {
            carListLive.observe(requireActivity()) {
                adapter.setData(it)
            }
        }
    }

}