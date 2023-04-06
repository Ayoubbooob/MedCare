package com.bosseurs.medcare.ui.screens.information

import org.intellij.lang.annotations.Language


@Language("Markdown")

const val INFO_OBESITE = """
Le surpoids et l'obésité sont définis comme une accumulation anormale ou excessive de graisse, qui nuit à la santé.
    
On considère qu'une personne est en surpoids lorsque son indice de masse corporelle (IMC) est supérieur à 25 et qu'elle est obèse lorsque celui-ci est supérieur à 30.

On peut prévenir l'obésité.

# Les Causes de l'Obésité
* le déséquilibre énergétique entre les calories consommées et dépensées;
* la consommation d’aliments très caloriques riches en lipides;
* le manque d'activité physique en raison de la nature de plus en plus sédentaire de nombreuses formes de travail, de l’évolution des modes de transport et de l’urbanisation croissante.

# Les Conséquences de l'Obésité
* les maladies cardiovasculaires (principalement les cardiopathies et les accidents vasculaires cérébraux);
* le diabète;
* les troubles musculo-squelettiques, en particulier l’arthrose – une maladie dégénérative des articulations, très invalidante;
* certains cancers (de l’endomètre, du sein, des ovaires, de la prostate, du foie, de la vésicule biliaire, du rein et du colon).

Dans le cas des enfants, des études ont révélé que sans intervention, les enfants et les adolescents obèses le resteront probablement une fois adultes.

# Comment réduire la charge du surpoids et de l’obésité?
* limiter l’apport énergétique provenant de la consommation des lipides totaux et de sucres;
* consommer davantage de fruits et légumes, de légumineuses, de céréales complètes et de noix;
* avoir une activité physique régulière (60 minutes par jour pour un enfant et 150 minutes par semaine pour un adulte).

"""


@Language("Markdown")
const val MIXED_MD = """
### Markdown Header
This is regular text without formatting in a single paragraph.
![Serious](file:///android_asset/serios.jpg)
Images can also be inline: ![Serious](file:///android_asset/serios.jpg). [Links](http://hellsoft.se) and `inline code` also work. This *is* text __with__ inline styles for *__bold and italic__*. Those can be nested.
Here is a code block:
```javascript
function codeBlock() {
    return true;
}
```
+ Bullet
+ __Lists__
+ Are
+ *Cool*
1. **First**
1. *Second*
1. Third
1. [Fourth is clickable](https://google.com)  
   1. And
   1. Sublists
1. Mixed
   - With
   - Bullet
   - Lists
100) Lists
100) Can
100) Have
100) *Custom*
100) __Start__
100) Numbers
- List
- Of
- Items
  - With
  - Sublist
> A blockquote is useful for quotes!
"""