package com.randomuser.app.utils

import android.content.Context
import android.widget.Toast

fun Context.showError(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}