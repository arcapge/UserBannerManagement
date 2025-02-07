package com.cg.arpisinh.bannerandusermanagement.repositories

import com.google.firebase.functions.FirebaseFunctions


class NotificationRepository {
    fun sendPushNotification(title: String, message: String) {
        val data = mapOf("title" to title, "message" to message)
        FirebaseFunctions.getInstance()
            .getHttpsCallable("sendPushNotification")
            .call(data)
    }
}
