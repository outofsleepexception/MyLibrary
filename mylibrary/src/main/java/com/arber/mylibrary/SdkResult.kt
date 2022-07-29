package com.arber.mylibrary

sealed class SdkResult {
    class Success(val successMessage: String) : SdkResult()
    object Cancel : SdkResult()
    object Error : SdkResult()
}
