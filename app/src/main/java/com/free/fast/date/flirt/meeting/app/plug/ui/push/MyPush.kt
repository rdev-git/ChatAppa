package com.free.fast.date.flirt.meeting.app.plug.ui.push

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.content.edit
import com.free.fast.date.flirt.meeting.app.R
import com.free.fast.date.flirt.meeting.app.plug.data.fetchGirlsList
import com.free.fast.date.flirt.meeting.app.web.WebActivity
import androidx.core.content.FileProvider
import com.free.fast.date.flirt.meeting.app.BuildConfig
import java.io.File
import android.graphics.BitmapFactory

import android.graphics.Bitmap

import android.content.res.AssetManager
import java.io.InputStream


class MyPush: BroadcastReceiver() {

    @SuppressLint("ServiceCast", "RemoteViewLayout", "UnspecifiedImmutableFlag")
    override fun onReceive(context: Context?, intent: Intent?) {
        val notificationManager: NotificationManager =
            context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notificationIntent = Intent(context, WebActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        val prefs = context.getSharedPreferences("SP", Context.MODE_PRIVATE)
        var lastId = prefs.getInt("idlast", 0)



        val contentView = RemoteViews(context.packageName, R.layout.my_push)
        contentView.setImageViewResource(R.id.imagePush, R.drawable.image);
        val assetManager: AssetManager = context.assets
        val file: InputStream = assetManager.open(fetchGirlsList()[lastId].avatar.removePrefix("file:///android_asset/"))
        val bitmap = BitmapFactory.decodeStream(file)
        contentView.setImageViewBitmap(R.id.imageIconPush, bitmap)
        contentView.setTextViewText(R.id.titlePush, fetchGirlsList()[lastId].name)
        contentView.setTextViewText(R.id.deckPush, fetchGirlsList()[lastId].pushDescription)
        if (lastId + 1 == 20) {
            lastId = 0
        }
        prefs.edit { putInt("idlast", lastId + 1) }


        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val mNotifyBuilder = NotificationCompat.Builder(context)
            .setSmallIcon(R.drawable.image)
            .setPriority(Notification.PRIORITY_MAX)
            .setContentIntent(pendingIntent)
            .setContent(contentView)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "idChanfdasf"
            val channel = NotificationChannel(
                channelId,
                "ansade",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
            mNotifyBuilder.setChannelId(channelId)
        }
        notificationManager.notify((0..1000).random(), mNotifyBuilder.build());
    }
}