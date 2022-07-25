package com.free.fast.date.flirt.meeting.app.web

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import android.view.Window
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.databinding.ActivityWebBinding
import com.free.fast.date.flirt.meeting.app.plug.ui.main.MainPlugActivity
import com.free.fast.date.flirt.meeting.app.plug.ui.push.MyPush
import com.free.fast.date.flirt.meeting.app.user_poll.UserPollActivity
import java.util.*

class WebActivity : AppCompatActivity(R.layout.activity_web) {
    private lateinit var myPref: SharedPreferences
    private val binding by viewBinding(ActivityWebBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Log.e("TAG", "WebActivity")

        val alarmIntent =
            Intent(applicationContext, MyPush::class.java).let { intent ->
                PendingIntent.getBroadcast(
                    applicationContext,
                    0,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT,
                )
            }
        val calendar = Calendar.getInstance()
        val alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmMgr.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis + 600000,
            100,
            alarmIntent
        )

        supportActionBar?.hide()
        myPref = getSharedPreferences("SP", Context.MODE_PRIVATE)

        Log.e("TAG", "info from prefs -> ${myPref.getString("web", "not info")}")

        binding.viewANy.settings.apply {
            javaScriptEnabled = true
            builtInZoomControls = true
            allowContentAccess = true
            setSupportZoom(true)
        }
        binding.viewANy.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                checkkUrl(url = url.toString())
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                Log.e("TAG", "last url -> $url")
                myPref.edit { putString("web", url) }
            }
        }


        if (myPref.getString("web", "").isNullOrEmpty()){
            binding.viewANy.loadUrl("https://valedatinglove.info/index.php")
            binding.viewANy.isVisible = true
        }else{
            binding.viewANy.loadUrl(myPref.getString("web", "").toString())
            binding.viewANy.isVisible = true
            Log.d("fdsf", myPref.getString("web", "").toString())
        }
    }

    @SuppressLint("ServiceCast", "UnspecifiedImmutableFlag")
    private fun checkkUrl(url: String){
        if (url.equals("https://www.google.com/")){
            if (myPref.getString("somethisddPass", "").isNullOrEmpty()) {
                startActivity(Intent(this@WebActivity, UserPollActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this@WebActivity, MainPlugActivity::class.java))
                finish()
            }

        } else {
            val alarmIntent =
                Intent(applicationContext, MyPush::class.java).let { intent ->
                    Log.e("TAG", "INTENT SUCCESS")
                    PendingIntent.getBroadcast(
                        applicationContext,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT,
                    )
                }
            val calendar = Calendar.getInstance()
            val alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmMgr.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis + 10,
                60000,
                alarmIntent
            )
        }
    }


}