package com.free.fast.date.flirt.meeting.app.plug.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class Girl(
    val name: String,
    val city: String,
    val age: Int,
    val description: String,
    val avatar: String,
    val pushDescription: String
): Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
    }
}