package com.example.data.remote.dto

data class ApiResponseDto(
    val results: List<UserDto>?,
    val info: InfoDto?
)