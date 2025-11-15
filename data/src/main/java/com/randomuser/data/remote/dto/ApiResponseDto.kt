package com.randomuser.data.remote.dto

data class ApiResponseDto(
    val results: List<UserDto>?,
    val info: InfoDto?
)