package com.bosseurs.medcare.ui.screens.obesite

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min

@Composable
fun WeightPicker(
    modifier: Modifier = Modifier,
    weight: Int,
    onWeightChanged: (Int) -> Unit,
    weightRange: IntRange = 0..150,
    step: Int = 1
) {
    var weightValue by remember { mutableStateOf(weight) }

    Box(
        modifier = modifier
            .size(200.dp)
            .background(Color.LightGray, CircleShape)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        BoxWithConstraints {
            val diameter = min(maxWidth, maxHeight)
            val radius = diameter / 2f
            val center = Offset(radius , radius)

            val angleStep = 360f / weightRange.count()
            val startAngle = 270f
            val currentAngle = startAngle + (weightValue - weightRange.first) * angleStep

            Canvas(
                modifier = Modifier
                    .size(diameter)
            ) {
                drawCircle(Color.White, radius, center)

                // Draw weight range markers
                for (i in weightRange) {
                    val angle = startAngle + i * angleStep
                    val markerRadius = diameter / 2f * 0.9f
                    val x = kotlin.math.cos(angle.toRadians()) * markerRadius + center.x
                    val y = kotlin.math.sin(angle.toRadians()) * markerRadius + center.y

                    drawCircle(Color.LightGray, diameter / 30f, Offset(x, y))
                }

                // Draw current weight indicator
                val weightIndicatorRadius = diameter / 2f * 0.7f
                val indicatorX = kotlin.math.cos(currentAngle.toRadians()) * weightIndicatorRadius + center.x
                val indicatorY = kotlin.math.sin(currentAngle.toRadians()) * weightIndicatorRadius + center.y
                val indicatorSize = diameter / 20f

                drawCircle(Color.Blue, indicatorSize, Offset(indicatorX, indicatorY))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = diameter.dp / 2 + 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    if (weightValue > weightRange.first) {
                        weightValue -= step
                        onWeightChanged(weightValue)
                    }
                }) {
                    Text(text = "-")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    if (weightValue < weightRange.last) {
                        weightValue += step
                        onWeightChanged(weightValue)
                    }
                }) {
                    Text(text = "+")
                }
            }
        }
    }
}

private fun Float.toRadians(): Float = (this * PI / 180f).toFloat()
