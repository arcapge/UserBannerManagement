package com.cg.arpisinh.bannerandusermanagement.models

data class Broadcast(
    val broadcastId: String = "",
    val message: String = "",
    val sentBy: String = "", // Admin user ID
    val sentAt: Long = System.currentTimeMillis()
) {
    constructor() : this("", "", "", 0)
}
