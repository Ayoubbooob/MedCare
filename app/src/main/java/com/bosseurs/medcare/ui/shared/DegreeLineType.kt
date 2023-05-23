package com.bosseurs.medcare.ui.shared


sealed class DegreeLineType{
    object TenTypeLine : DegreeLineType()
    object FiveTypeLine : DegreeLineType()
    object NormalTypeLine : DegreeLineType()
}