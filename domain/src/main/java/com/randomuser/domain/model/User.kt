package com.randomuser.domain.model

data class User(
    val localId: Int,
    val gender: String?,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: Dob,
    val registered: Registered,
    val phone: String,
    val cell: String,
    val userId: UserId,
    val picture: Picture,
    val nat: String
)