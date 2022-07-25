package com.free.fast.date.flirt.meeting.app.plug.ui.questionnaires

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.FragmentQuestionnairesBinding
import com.free.fast.date.flirt.meeting.app.plug.data.Girl
import com.free.fast.date.flirt.meeting.app.plug.data.fetchGirlsList
import kotlin.random.Random
import kotlin.random.nextInt

class QuestionnairesFragment : Fragment(R.layout.fragment_questionnaires) {
    private val binding by viewBinding(FragmentQuestionnairesBinding::bind)
    private val rejectedGirlList: MutableList<Int> = mutableListOf()
    private var passedGirls: Int = 0
    private var i = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateView(optionGirlsFromList(), view)

        binding.fabFailure.setColorFilter(Color.argb(255, 255, 255, 255));
        binding.fabLiked.setColorFilter(Color.argb(255, 255, 255, 255));

        binding.fabLiked.setOnClickListener {
            passedGirls++
            updateView(optionGirlsFromList(), view)
        }

        binding.fabFailure.setOnClickListener {
            passedGirls++
            updateView(optionGirlsFromList(), view)
        }

        binding.report.setOnClickListener { findNavController().navigate(R.id.action_questionnairesFragment_to_reportFragment) }

    }

    private fun updateView(girl: Girl?, view: View) {
        Glide.with(view)
            .load(girl?.avatar)
            .centerCrop()
            .into(binding.avatar)
        binding.age.text = "${girl?.age} years old"
        binding.name.text = girl?.name
    }

    private fun optionGirlsFromList(): Girl? {
        val random = Random.nextInt(0..18)
            if(random !in rejectedGirlList) {
                rejectedGirlList.add(random)
                return fetchGirlsList()[random]
            }
        return optionGirlsFromList().apply {
            i++
            if (i>4) rejectedGirlList.clear()
        }
    }
}