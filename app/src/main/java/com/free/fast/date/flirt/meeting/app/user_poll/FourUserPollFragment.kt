package com.free.fast.date.flirt.meeting.app.user_poll

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentFourUserPollBinding
import com.free.fast.date.flirt.meeting.app.plug.ui.main.MainPlugActivity
import com.free.fast.date.flirt.meeting.app.web.WebActivity

class FourUserPollFragment : Fragment(R.layout.fragment_four_user_poll) {

    private val binding by viewBinding(FragmentFourUserPollBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            startActivity(Intent(activity, WebActivity::class.java))
        }
        binding.police.setOnClickListener { findNavController().navigate(R.id.action_fourUserPollFragment_to_policyFragment) }
        binding.term.setOnClickListener { findNavController().navigate(R.id.action_fourUserPollFragment_to_termsFragment) }

        val myPref = activity?.getSharedPreferences("SP", Context.MODE_PRIVATE)
        myPref?.edit { putString("somethisddPass", "+1") }
    }
}