package com.free.fast.date.flirt.meeting.app.user_poll

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentUserPollBinding

class UserPollFragment : Fragment(R.layout.fragment_user_poll) {
    private val binding by viewBinding(FragmentUserPollBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_userPollFragment2_to_twoUserPollFragment)
        }
    }
}