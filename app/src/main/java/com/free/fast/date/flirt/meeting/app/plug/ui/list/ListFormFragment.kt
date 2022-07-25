package com.free.fast.date.flirt.meeting.app.plug.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentListFormBinding
import com.free.fast.date.flirt.meeting.app.plug.data.Girl
import com.free.fast.date.flirt.meeting.app.plug.data.fetchGirlsList


class ListFormFragment : Fragment(R.layout.fragment_list_form) {
    private val binding by viewBinding(FragmentListFormBinding::bind)
    private val listFormAdapter = ListFormAdapter { onClickItem(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recycler.apply {
            adapter = listFormAdapter
            layoutManager = LinearLayoutManager(context)
        }
        listFormAdapter.submitList(fetchGirlsList())
    }

    private fun onClickItem(girl: Girl) {
        val bundle = Bundle().apply { putParcelable("detail", girl) }
        findNavController().navigate(R.id.action_listFormFragment_to_detailFragment, bundle)
    }
}