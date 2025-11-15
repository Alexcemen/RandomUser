package com.randomuser.app.ui.models

import com.randomuser.app.ui.models.enums.Nationality

data class UserUi(
    val userId: Int,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val nationality: Nationality,
    val mediumPicture: String
)
