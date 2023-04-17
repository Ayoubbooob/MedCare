
package com.bosseurs.medcare.data

import com.bosseurs.medcare.ui.utils.BlockModel
import com.bosseurs.medcare.ui.utils.enums.ImportanceLevel
import com.bosseurs.medcare.R



// Specify here your fake Data, for example, I've added Procedures realises blocks
object FakeBlockDatabase {
    val proceduresBlocksList = listOf(
        BlockModel(
            "Mesures hygieno-dietectiques",
            "Il y a 1 jour",
            R.drawable.int4,
            ImportanceLevel.URGENT
        ),
        BlockModel(
            "Traitement médical",
            "Il y a 1 heure",
            R.drawable.int5,
            ImportanceLevel.IMPORTANT
        ),
        BlockModel(
            "Traitement chirurgical",
            "Il y a 1 mois",
            R.drawable.welcome_img,
            ImportanceLevel.PASURGENT
        ),

    )
}



