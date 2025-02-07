package com.cg.arpisinh.bannerandusermanagement.models

data class PushNotification(
    val title: String = "",
    val message: String = "",
    val targetUserId: String = "" // If empty, send to all users
) {
    constructor() : this("", "", "")
}
