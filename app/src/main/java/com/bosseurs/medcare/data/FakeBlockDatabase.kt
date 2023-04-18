
package com.bosseurs.medcare.data

import com.bosseurs.medcare.ui.utils.BlockModel
import com.bosseurs.medcare.ui.utils.enums.ImportanceLevel
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.screens.procedures.ContentModel
import com.bosseurs.medcare.ui.screens.procedures.Mesures_hygieno_dietectiques_details
import com.bosseurs.medcare.ui.screens.procedures.Mesures_hygieno_dietectiques_intro


// Specify here your fake Data, for example, I've added Procedures realises blocks
object FakeBlockDatabase {
    val proceduresBlocksList = listOf(
        BlockModel(
            id = 1,
            title = "Mesures hygieno-dietectiques",
            dateAdded = "Il y a 1 jour",
            image = R.drawable.int4,
            importanceLevel = ImportanceLevel.URGENT,
            text = ContentModel(Mesures_hygieno_dietectiques_intro, Mesures_hygieno_dietectiques_details )
        ),
        BlockModel(
            title = "Traitement médical",
            dateAdded = "Il y a 1 heure",
            image = R.drawable.int5,
            importanceLevel = ImportanceLevel.IMPORTANT,
            text = ContentModel(Mesures_hygieno_dietectiques_intro, Mesures_hygieno_dietectiques_details )

    ),
        BlockModel(
            title = "Traitement chirurgical",
            dateAdded = "Il y a 1 mois",
            image = R.drawable.welcome_img,
            importanceLevel = ImportanceLevel.PASURGENT,
            text = ContentModel(Mesures_hygieno_dietectiques_intro, Mesures_hygieno_dietectiques_details )
        ),

    )
}



