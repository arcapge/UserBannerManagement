package com.cg.arpisinh.bannerandusermanagement.models

data class ContactRequest(
    val requestId: String = "",
    val requesterId: String = "", // User requesting contact access
    val profileId: String = "", // Profile whose contact is requested
    val approved: Boolean = false,
    val requestedAt: Long = System.currentTimeMillis()
) {
    constructor() : this("", "", "", false, 0)
}
