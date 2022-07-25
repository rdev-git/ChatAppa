package com.free.fast.date.flirt.meeting.app.plug.ui.questionnaires

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentReportBinding

class ReportFragment : Fragment(R.layout.fragment_report) {
    private val binding by viewBinding(FragmentReportBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.send.setOnClickListener { findNavController().navigateUp() }
    }
}