package com.randomuser.app.ui.models.enums

import androidx.annotation.DrawableRes
import com.randomuser.app.R

enum class Nationality(
    val title: String,
    @DrawableRes val flagRes: Int
) {
    AU("Australia",       R.drawable.flag_au),
    BR("Brazil",          R.drawable.flag_br),
    CA("Canada",          R.drawable.flag_ca),
    CH("Switzerland",     R.drawable.flag_ch),
    DE("Germany",         R.drawable.flag_de),
    DK("Denmark",         R.drawable.flag_dk),
    ES("Spain",           R.drawable.flag_es),
    FI("Finland",         R.drawable.flag_fi),
    FR("France",          R.drawable.flag_fr),
    GB("United Kingdom",  R.drawable.flag_gb),
    IE("Ireland",         R.drawable.flag_ie),
    IN("India",           R.drawable.flag_in),
    IR("Iran",            R.drawable.flag_ir),
    MX("Mexico",          R.drawable.flag_mx),
    NL("Netherlands",     R.drawable.flag_nl),
    NO("Norway",          R.drawable.flag_no),
    NZ("New Zealand",     R.drawable.flag_nz),
    RS("Serbia",          R.drawable.flag_rs),
    TR("Turkey",          R.drawable.flag_tr),
    UA("Ukraine",         R.drawable.flag_ua),
    US("United States",   R.drawable.flag_us),
    NONE("NONE", 1)
}