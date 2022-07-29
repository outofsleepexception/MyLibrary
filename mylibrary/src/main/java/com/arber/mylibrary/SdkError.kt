package com.arber.mylibrary

import android.os.Parcel
import android.os.Parcelable

data class SdkError(
    val code: Int,
    val message: String?,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(code)
        parcel.writeString(message)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SdkError> {
        override fun createFromParcel(parcel: Parcel): SdkError {
            return SdkError(parcel)
        }

        override fun newArray(size: Int): Array<SdkError?> {
            return arrayOfNulls(size)
        }
    }
}