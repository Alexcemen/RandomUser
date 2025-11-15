package com.randomuser.app.ui.models

import com.randomuser.app.ui.models.enums.Nationality
import com.randomuser.domain.model.UserId

data class UserUi(
    val userId: UserId,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val nationality: Nationality,
    val mediumPicture: String
)
