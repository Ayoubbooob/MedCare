package com.bosseurs.medcare.ui.screens.appointment

enum class DaysEnum(val value : String){
    LUNDI("Lun"),
    MARDI("Mar"),
    MERCREDI("Mer"),
    JEUDI("Jeu"),
    VENDREDI("Ven"),
    SAMEDI("Sam"),
    DIMANCHE("Dim"),
}

enum class DaysNum(val value: String){

}

fun getAllDaysName() : List<DaysEnum>{
    return listOf(
        DaysEnum.LUNDI,
        DaysEnum.MARDI,
        DaysEnum.MERCREDI,
        DaysEnum.JEUDI,
        DaysEnum.VENDREDI,
        DaysEnum.SAMEDI,
        DaysEnum.DIMANCHE)
}