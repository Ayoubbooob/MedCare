package com.bosseurs.medcare.ui.utils

import com.bosseurs.medcare.ui.utils.enums.ImportanceLevel

data class BlockModel(
    val title : String,
    val dateAdded : String,
    val image : Int,
    val importanceLevel: ImportanceLevel
)