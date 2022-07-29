package com.arber.mylibrary

import androidx.activity.result.ActivityResultLauncher

object SdkLauncher {

    fun launchFlow(resultLauncher: ActivityResultLauncher<Unit>) {
        resultLauncher.launch(Unit)
    }
}