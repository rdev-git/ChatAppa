package com.free.fast.date.flirt.meeting.app.user_poll

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentThreeUserPollBinding
import com.free.fast.date.flirt.meeting.app.plug.ui.main.MainPlugActivity


class ThreeUserPollFragment : Fragment(R.layout.fragment_three_user_poll) {
    private val binding by viewBinding(FragmentThreeUserPollBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_threeUserPollFragment_to_fourUserPollFragment)
        }
    }
}