package com.cg.arpisinh.bannerandusermanagement.models

data class Member(
    val memberId: String = "",
    val name: String = "",
    val position: String = "",
    val contact: String = "",
    val address: String = ""
) {
    constructor() : this("", "", "", "", "")
}
