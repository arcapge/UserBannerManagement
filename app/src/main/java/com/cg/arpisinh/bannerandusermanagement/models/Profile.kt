package com.cg.arpisinh.bannerandusermanagement.models

data class Profile(
    val profileId: String = "",
    val name: String = "",
    val age: Int = 0,
    val fatherName: String = "",
    val motherName: String = "",
    val education: String = "",
    val salary: Double = 0.0,
    val contact: String = "",
    val address: String = "",
    val height: String = "",
    val dob: String = "",
    val images: List<String> = emptyList(), // Firebase Storage URLs
    val adminApproved: Boolean = false,
    val requestedBy: String = "", // User ID who added this profile
    val createdAt: Long = System.currentTimeMillis()
) {
    constructor() : this("", "", 0, "", "", "", 0.0, "", "", "", "", emptyList(), false, "", 0)
}
