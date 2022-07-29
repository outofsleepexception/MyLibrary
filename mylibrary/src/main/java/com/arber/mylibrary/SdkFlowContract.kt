package com.arber.mylibrary

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class SdkFlowContract : ActivityResultContract<Unit, SdkResult>() {

    override fun createIntent(context: Context, input: Unit?) = Intent(
        context, SdkFlowActivity::class.java
    )

    override fun parseResult(resultCode: Int, intent: Intent?): SdkResult {
        if (resultCode != Activity.RESULT_OK) {
            val error: SdkError? = intent?.getParcelableExtra("error")
            return if (error != null) {
                SdkResult.Error
            } else {
                SdkResult.Cancel
            }
        }

        return SdkResult.Success("success")
    }
}