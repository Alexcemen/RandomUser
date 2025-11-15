package com.randomuser.domain.model

data class ApiResponse(
    val results: List<User>,
    val info: Info
)