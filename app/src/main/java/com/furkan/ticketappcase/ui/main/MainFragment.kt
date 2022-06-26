package com.furkan.ticketappcase.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.furkan.ticketappcase.base.BaseFragment
import com.furkan.ticketappcase.data.model.Data
import com.furkan.ticketappcase.data.model.Flights
import com.furkan.ticketappcase.data.model.data.Airline
import com.furkan.ticketappcase.databinding.MainFragmentBinding
import com.furkan.ticketappcase.ui.main.adapter.MainAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding,MainViewModel>() {

    override val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: MainAdapter
    private var productList: Data? = null


    override fun onCreateFinished() {
        viewModel.getData(requireContext())

        viewModel.getData.observe(viewLifecycleOwner,{
            productList = it
            productList?.data?.airlines?.let { it1 -> sendAdapterData(it1) }
            it?.data?.flights?.let { it1 -> bindRecyclerViewData(it1) }

        })

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun bindRecyclerViewData(data: Flights) {
        binding?.rycView?.visibility = View.VISIBLE

        adapter.set(data.departure)
        adapter.notifyDataSetChanged()

    }

    override fun layoutResource(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainFragmentBinding {
        return MainFragmentBinding.inflate(inflater, container, false)
    }

    override fun configureUiItems() {
        binding?.rycView?.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
    }

    private fun sendAdapterData(airline: ArrayList<Airline>) {
        adapter = MainAdapter(null,airline)
        binding?.rycView?.adapter = adapter
    }


}