package com.free.fast.date.flirt.meeting.app.user_poll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.NavHostFragment
import com.free.fast.date.flirt.meeting.app.R

class UserPollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_poll)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.user_poll_nav_host_container
        ) as NavHostFragment
        val navController = navHostFragment.navController
    }
}