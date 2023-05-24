package com.bosseurs.medcare.ui.httpRequest

data class Patient (
    val first_name: String,
    val last_name: String,
    val cin: String,
    val ppr: String,
    val num: String,
    val password: String,
    var id : String? = null,
)
