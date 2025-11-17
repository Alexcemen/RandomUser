package com.randomuser.app.utils

import com.randomuser.app.ui.models.LocationUi
import com.randomuser.app.ui.models.StreetUi
import com.randomuser.app.ui.models.UserInfoUi
import com.randomuser.domain.model.User

fun mapUserToUserInfoUi(user: User): UserInfoUi {
    return UserInfoUi(
        firstName = user.name.first,
        lastName = user.name.last,
        gender = user.gender,
        age = user.dob.age,
        dateOfBirth = formatDate(user.dob.date),
        phone = user.phone,
        email = user.email,
        location = LocationUi(
            street = StreetUi(
                name = user.location.street.name,
                number = user.location.street.number
            ),
            city = user.location.city,
            state = user.location.state,
            country = user.location.country,
            postcode = user.location.postcode
        ),
        picture = user.picture.medium
    )
}