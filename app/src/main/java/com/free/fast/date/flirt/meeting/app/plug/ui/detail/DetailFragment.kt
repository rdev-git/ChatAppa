package com.free.fast.date.flirt.meeting.app.plug.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentDetailBinding
import com.free.fast.date.flirt.meeting.app.databinding.FragmentSettingsBinding
import com.free.fast.date.flirt.meeting.app.plug.data.Girl

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding(FragmentDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("SettingsFragment", "It's settingsFragment")

        val args = arguments?.getParcelable<Girl>("detail")

        binding.description.text = args?.description
        binding.age.text = "${args?.age} years"
        activity?.actionBar?.title = args?.name
        binding.name.text = args?.name
        Glide.with(view)
            .load(args?.avatar)
            .into(binding.avatar)
    }
}