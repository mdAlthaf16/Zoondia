package com.task.zoondia.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.task.zoondia.ui.theme.DarkGreen

@Composable
fun RatingView(
    rating: String,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(10.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(100))
            .background(DarkGreen)
            .padding(vertical = 1.dp)
            ,
        contentAlignment = Alignment.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.Star, contentDescription = "rating_star", tint = Color.White,
                modifier = Modifier
                    .size(25.dp)
                    .padding(start = 10.dp)
            )
            Text(
                text = rating, style = TextStyle(color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 12.sp),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 5.dp, end = 10.dp)
            )
        }
    }
}