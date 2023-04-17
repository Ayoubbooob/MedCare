package com.bosseurs.medcare.ui.utils

import com.bosseurs.medcare.ui.screens.procedures.ContentModel
import com.bosseurs.medcare.ui.utils.enums.ImportanceLevel

var i : Int = 0 //TODO - We will fix this later
data class BlockModel(
    val id : Int = ++i,
    val title : String,
    val dateAdded : String,
    val image : Int,
    val importanceLevel: ImportanceLevel,
    val text : ContentModel,

)