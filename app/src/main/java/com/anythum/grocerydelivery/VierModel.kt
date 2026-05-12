package com.anythum.grocerydelivery

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GroceryVierModel : ViewModel() {
    private var _otpSent = false
    val otpSent : Boolean= _otpSent

    fun checkOtpStatus() {
        _otpSent = true
    }
}