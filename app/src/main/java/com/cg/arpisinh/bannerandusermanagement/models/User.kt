package com.cg.arpisinh.bannerandusermanagement.models

data class User(
    val userId: String = "",
    val name: String = "",
    val phone: String = "",
    val role: String = "", // "admin" or "user"
    val profileCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    constructor() : this("", "", "", "", false, 0)
}
