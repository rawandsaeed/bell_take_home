package com.eos_gnss.bellapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eos_gnss.bellapp.Application
import com.eos_gnss.bellapp.data.CarStore
import com.eos_gnss.bellapp.R
import com.eos_gnss.bellapp.base.BaseFragment
import com.eos_gnss.bellapp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private var carStore: CarStore? = null
    private lateinit var adapter: CarAdapter

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCars()
        initView()
    }

    private fun initView() {
        val recyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        adapter = CarAdapter(requireContext()).apply {
            carStore?.getCars()?.let {
                setData(it)
            }
        }
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                context?.getDrawable(R.drawable.divider)?.let { setDrawable(it) }
            }
        )

    }

    private fun getCars() {
        carStore = (requireActivity().applicationContext as Application).getCarStore()
    }

}