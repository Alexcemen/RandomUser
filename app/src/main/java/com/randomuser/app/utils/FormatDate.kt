package com.randomuser.app.utils

import java.time.Instant
import java.time.ZoneId

fun formatDate(date: String): String {
    return try {
        Instant.parse(date)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
            .toString()
    } catch (e: Exception) {
        date
    }
}