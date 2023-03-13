package com.bosseurs.medcare.ui.shared

/*
Readme before you start working

************* CustomTextField *******************
How to use it ?
Example :
This example for Username TextField

CustomTextField(
        labelText = R.string.username,          //Avoid hard coded string, every string you need you have to added in string.xml file
        leadingIconId = R.drawable.person_icon,  //the icon that appear at the beginning of TextField  **Custom Icon that I added it in drawable folder
        iconDescription = "Person Icon" ,   //The description of the icon that you've used it
        keyboardType = KeyboardType.Text,       //KeyboardType.Text || KeyboardType.Password for password .. you can check the doc
        trailingIconId = null,  // the icon that appear at the end of TextField
)

************* CustomButton *******************
How to use it ?
Example :
This example for CONTINUE BUTTON

        CustomButton(
        textId = R.string.CONTINUE,  //Id of the text CONTINUE, you will find it in res/string
        onClick = {},  //When the button clicked
        color = BlueButtonColor, // All the color you will find it in theme/Color.kt
        textColor = TextForBlueButtonColor  //
        )


**************** Big Text ***************************
Text(text = "Tout savoir sur l'obésité", style = MaterialTheme.typography.h1) // h1 for the big text, you have to use it like that MaterialTheme.typography.h1

**************** Small Text ***************************

Text(text = "Etiam mollis metus non purus faucibus sollicitudin. Pellentesque sagittis mi. Integer.",
            style = MaterialTheme.typography.caption)        caption , the same method as previous




 */