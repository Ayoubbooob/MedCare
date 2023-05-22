package com.bosseurs.medcare.ui.screens.obesite

import android.graphics.Paint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bosseurs.medcare.ui.shared.PickerStyle
import kotlinx.coroutines.delay
import java.util.*
import kotlin.math.*

@Composable
fun ObesitePoid(
    modifier: Modifier = Modifier,
    pickerStyle : PickerStyle,
    time:()->Long,
    circleRadius:Float,
    outerCircleThickness:Float,
) {

    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var targetDistant by remember {
        mutableStateOf(0f)
    }

    var startDragPointX by remember {
        mutableStateOf(0f)
    }
    var startDragPointY by remember {
        mutableStateOf(0f)
    }

    var oldDragPoint by remember {
        mutableStateOf(0f)
    }

    var selectedWeight by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = modifier
    ){
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures(){ change, _ ->

                    }
                }
        ){
            val width = size.width
            val height = size.height
            circleCenter = Offset(x = width/2f, y = height/2f)
            val date = Date(time())
            val cal = Calendar.getInstance()
            cal.time = date
            val hours = cal.get(Calendar.HOUR_OF_DAY)
            val minutes = cal.get(Calendar.MINUTE)
            val seconds = cal.get(Calendar.SECOND)



            drawCircle(
                style = Stroke(
                    width = outerCircleThickness
                ),
                brush = Brush.linearGradient(
                    listOf(
                        Color.White.copy(0.45f),
                        Color.DarkGray.copy(0.35f)
                    )
                ),
                radius = circleRadius+outerCircleThickness/2f,
                center = circleCenter
            )
            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        Color.White.copy(0.45f),
                        Color.DarkGray.copy(0.25f)
                    )
                ),
                radius = circleRadius,
                center = circleCenter
            )
            drawCircle(
                color = Color.Gray,
                radius = 15f,
                center = circleCenter
            )

            val littleLineLength = circleRadius*0.1f
            val largeLineLength = circleRadius*0.2f
            for(weight in pickerStyle.minHeight..pickerStyle.maxHeight){
                val angleInDegrees = weight*360f/60
                val angleInRad = angleInDegrees * PI / 180f + PI /2f
                val lineLength = if(weight%5 == 0)largeLineLength else littleLineLength
                val lineThickness = if(weight%5 == 0) 4f else 1.5f

                val start = Offset(
                    x = (circleRadius * cos(angleInRad) + circleCenter.x).toFloat(),
                    y = (circleRadius * sin(angleInRad) + circleCenter.y).toFloat()
                )

                val end = Offset(
                    x = (circleRadius * cos(angleInRad) + circleCenter.x).toFloat(),
                    y = (circleRadius * sin(angleInRad) + lineLength + circleCenter.y).toFloat()
                )
                rotate(
                    angleInDegrees+180,
                    pivot = start
                ){
                    drawContext.canvas.nativeCanvas.apply{
                        if (lineLength == largeLineLength){
                            drawText(
                                abs(weight).toString(),
                                end.x  ,
                                end.y  ,
                                Paint().apply {
                                    this.textSize = 20.sp.toPx()
                                    this.textAlign = Paint.Align.CENTER
                                    this.color = android.graphics.Color.BLACK
                                    this.style = Paint.Style.FILL
                                    this.isAntiAlias = true })
                        }

                        drawLine(
                            color = Color.Gray,
                            start = start,
                            end = end,
                            strokeWidth = lineThickness.dp.toPx()
                        )

                    }


                }
            }

            val clockHands = listOf(ClockHands.Seconds,ClockHands.Minutes,ClockHands.Hours)

            clockHands.forEach { clockHand ->
                val angleInDegrees = when (clockHand) {
                    ClockHands.Seconds -> {
                        seconds * 360f/60f
                    }
                    ClockHands.Minutes -> {
                        (minutes + seconds/60f) * 360f/60f
                    }
                    ClockHands.Hours -> {
                        (((hours%12)/12f*60f)+minutes/12f) * 360f/60f
                    }
                }

                val lineLength = circleRadius * 0.8f
                val lineThickness = 3f
                val start = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y
                )

                val end = Offset(
                    x = circleCenter.x,
                    y = lineLength + circleCenter.y
                )
                drawLine(
                    color =  Color.Green ,
                    start = start,
                    end = end,
                    strokeWidth = lineThickness.dp.toPx()
                )
            }
        }
    }
}

enum class ClockHands {
    Seconds,
    Minutes,
    Hours
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
    var currentTimeInMs by remember {
        mutableStateOf(System.currentTimeMillis())
    }

    LaunchedEffect(key1 = true){
        while(true){
            delay(200)
            currentTimeInMs = System.currentTimeMillis()
        }
    }

        Box(
            modifier = Modifier
                .fillMaxSize()
            ,
            contentAlignment = Alignment.Center
        ){
            ObesitePoid(
                modifier = Modifier
                    .size(400.dp),
                pickerStyle = PickerStyle(),
                time = {
                    currentTimeInMs
                },
                circleRadius = 600f,
                outerCircleThickness = 50f
            )
        }

    }