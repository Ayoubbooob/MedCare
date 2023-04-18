package com.bosseurs.medcare.ui.utils.enums

enum class ImportanceLevel {
    URGENT, PASURGENT, IMPORTANT, PASIMPORTANT;


    override fun toString(): String {
        return when (this) {
            URGENT -> "Urgent"
            PASURGENT -> "Pas Urgent"
            IMPORTANT -> "Important"
            PASIMPORTANT -> "Pas Important"
        }
    }
}

