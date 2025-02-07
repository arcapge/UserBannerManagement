package com.cg.arpisinh.bannerandusermanagement.models

data class Banner(
    val bannerId: String = "",
    val imageUrl: String = "", // Firebase Storage URL
    val startDate: Long = 0, // Timestamp
    val endDate: Long = 0, // Timestamp
    val durationDays: Int = 0
) {
    constructor() : this("", "", 0, 0, 0)
}
