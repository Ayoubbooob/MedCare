package com.bosseurs.medcare.ui.shared

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.R
import com.bosseurs.medcare.ui.theme.BlueColor
import com.bosseurs.medcare.ui.theme.TextForBlueButtonColor
import com.bosseurs.medcare.ui.theme.Typography1
import kotlin.math.abs
import kotlin.math.roundToInt
import androidx.compose.ui.graphics.Color as ComposeColor


@Composable
fun SelectHeightScreen(targetHeight: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Top ,  modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)) {
            Column() {
                Text(text = stringResource(R.string.genre_select_message), style = Typography1.subtitle1)
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Column() {
                Text(text = stringResource(R.string.gennre_taille_bold), style = Typography1.h1)
            }

        }

        Row {
            Text(
                text = targetHeight.toString(),
                color = ComposeColor.Black,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier.align(Alignment.Bottom),
                text = "cm",
                textAlign = TextAlign.Center,
                color = ComposeColor.Red,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
fun PickerScreen(pickerStyle: PickerStyle, onHeightChange: (Int) -> Unit = {}) {

    var targetDistant by remember {
        mutableStateOf(0f)
    }

    var startDragPoint by remember {
        mutableStateOf(0f)
    }

    var oldDragPoint by remember {
        mutableStateOf(0f)
    }

    var selectedHeight by remember {
        mutableStateOf(0)
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.49f)
    ) {
        Canvas(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.49f)
            .align(Alignment.CenterEnd)
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = {
                        startDragPoint = it.y
                    },
                    onDragEnd = {
                        oldDragPoint = targetDistant
                    }
                ) { change, _ ->
                    val newDistance = oldDragPoint + (change.position.y - startDragPoint)
                    targetDistant = newDistance.coerceIn(
                        minimumValue = ((pickerStyle.initialHeight) * pickerStyle.spaceInterval - pickerStyle.maxHeight * pickerStyle.spaceInterval).toFloat(),
                        maximumValue = ((pickerStyle.initialHeight) * pickerStyle.spaceInterval - pickerStyle.minHeight * pickerStyle.spaceInterval).toFloat()
                    )
                }
            }
        ) {

            val middlePoint = Offset(x = maxWidth.toPx() / 2f, y = maxHeight.toPx() / 2f)

            drawContext.canvas.nativeCanvas.apply {
                val pickerLinesPath = Path().apply {
                    moveTo(middlePoint.x - pickerStyle.pickerWidth.toPx() / 2, 0f)
                    lineTo(middlePoint.x - pickerStyle.pickerWidth.toPx() / 2, constraints.maxHeight.toFloat())
                    moveTo(middlePoint.x + pickerStyle.pickerWidth.toPx() / 2, 0f)
                    lineTo(middlePoint.x + pickerStyle.pickerWidth.toPx() / 2, constraints.maxHeight.toFloat())
                }

                drawPath(pickerLinesPath, Paint().apply {
                    this.style = Paint.Style.STROKE
                    this.strokeWidth = pickerStyle.lineStroke
                    this.color = Color.BLACK
                    this.setShadowLayer(86f, 0f, 0f, Color.LTGRAY)
                })


                val indicator = Path().apply {
                    moveTo((middlePoint.x+ 10f), middlePoint.y)
                    lineTo((middlePoint.x + pickerStyle.pickerWidth.toPx() / 2), middlePoint.y- 2f)
                    moveTo((middlePoint.x+ 10f ), middlePoint.y)
                    lineTo((middlePoint.x + pickerStyle.pickerWidth.toPx() / 2), middlePoint.y+ 2f)
                    fillType = Path.FillType.EVEN_ODD
                }


                drawPath(indicator, Paint().apply {
                    this.color = Color.RED
                    this.style = Paint.Style.FILL_AND_STROKE
                    this.strokeWidth = pickerStyle.lineStroke
                    this.isAntiAlias = true
                })


                for (height in pickerStyle.minHeight..pickerStyle.maxHeight) {
                    val degreeLineScaleY =
                        middlePoint.y + (pickerStyle.spaceInterval * (height - pickerStyle.initialHeight.toFloat()) + targetDistant)
                    val lineType = when {
                        height % 10 == 0 -> DegreeLineType.TenTypeLine
                        height % 5 == 0 -> DegreeLineType.FiveTypeLine
                        else -> DegreeLineType.NormalTypeLine
                    }

                    val lineColor = when (lineType) {
                        DegreeLineType.TenTypeLine -> pickerStyle.tenTypeLineColor
                        DegreeLineType.FiveTypeLine -> pickerStyle.fiveTypeLineColor
                        else -> pickerStyle.normalTypeLineColor
                    }

                    val lineHeightSize = when (lineType) {
                        DegreeLineType.TenTypeLine -> pickerStyle.tenTypeLineHeight
                        DegreeLineType.FiveTypeLine -> pickerStyle.fiveTypeLineHeight
                        else -> pickerStyle.normalTypeLineHeight
                    }

                    this.drawLine(middlePoint.x - pickerStyle.pickerWidth.toPx() / 2 + 4 ,
                        degreeLineScaleY,
                        middlePoint.x - pickerStyle.pickerWidth.toPx() / 2 + lineHeightSize * 2,
                        degreeLineScaleY,
                        Paint().apply {
                            this.style = Paint.Style.STROKE
                            this.strokeWidth = pickerStyle.lineStroke
                            this.color = lineColor
                            this.isAntiAlias = true
                        }
                    )


                    if (abs(middlePoint.y - degreeLineScaleY.roundToInt()) < 5) {
                        selectedHeight = height
                        onHeightChange(selectedHeight)
                    }

                    if (lineType == DegreeLineType.TenTypeLine) {
                        val textBound = Rect()
                        Paint().getTextBounds(
                            abs(height).toString(),
                            0,
                            height.toString().length,
                            textBound
                        )

                        drawText(
                            abs(height).toString(),
                            middlePoint.x - pickerStyle.pickerWidth.toPx() / 2 + lineHeightSize * 2 + textBound.height() * 2 + pickerStyle.numberPadding,
                            (degreeLineScaleY) - textBound.width() / 2,
                            Paint().apply {
                                this.textSize = 20.sp.toPx()
                                this.textAlign = Paint.Align.CENTER
                                this.color = Color.BLACK
                                this.style = Paint.Style.FILL
                                this.isAntiAlias = true
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeightPreview(){
    var targetHeight by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SelectHeightScreen(targetHeight)

        //Spacer(modifier = Modifier.height(68.dp))
 
       Row(modifier = Modifier.fillMaxWidth()) {
           Image(modifier = Modifier
               .width(200.dp)
               .fillMaxHeight(0.94f) ,
               painter = painterResource(id = R.drawable.human_height_obseti),
               contentDescription ="this is a" )
           Spacer(modifier = Modifier.width(30.dp))
           PickerScreen(pickerStyle = PickerStyle()) { height ->
               targetHeight = height
           }
       }
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.Bottom) {
            CustomButtonObesite(
                textId = R.string.retourner_label, onClick = {}, color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)

            CustomButtonObesite(textId = R.string.CONTINUE, onClick = {}, color = BlueColor, textColor = TextForBlueButtonColor , CustomWidth = 176  , CustomHeight = 50)
        }

    }
}
