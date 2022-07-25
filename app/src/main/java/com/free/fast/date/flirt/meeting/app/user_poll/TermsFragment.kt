package com.free.fast.date.flirt.meeting.app.user_poll

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentFourUserPollBinding
import com.free.fast.date.flirt.meeting.app.databinding.TermsBinding
import com.free.fast.date.flirt.meeting.app.web.WebActivity

class TermsFragment : Fragment(R.layout.terms) {

    private val binding by viewBinding(TermsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}