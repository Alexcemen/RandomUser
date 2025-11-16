package com.randomuser.app.ui.models


data class UserInfoUi(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val age: Int,
    val dateOfBirth: String,
    val phone: String,
    val email: String,
    val location: LocationUi,
    val picture: String
)
