package com.cg.arpisinh.bannerandusermanagement.ui.activity.login.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var mobileNumber = mutableStateOf("")
        private set

    var selectedRole = mutableStateOf("User")
        private set

    var isValidNumber = mutableStateOf(true)
        private set

    fun updateMobileNumber(number: String) {
        mobileNumber.value = number
        isValidNumber.value = number.length == 10
    }

    fun updateRole(role: String) {
        selectedRole.value = role
    }

    fun sendOtp() {
        if (mobileNumber.value.length == 10) {

        }
    }
}