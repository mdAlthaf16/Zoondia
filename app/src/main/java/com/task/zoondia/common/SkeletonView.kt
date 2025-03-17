package com.task.zoondia.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonView(
    modifier: Modifier = Modifier,
    color: Color = Color.Gray.copy(0.2f),
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color)

    )
}