package com.task.zoondia.features.home.presentation.components

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.task.zoondia.R
import com.task.zoondia.features.home.domain.model.ResponseHome
import com.task.zoondia.ui.theme.DarkGreen

@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun ProductListItemView(
    item: ResponseHome,
    onClick: (ResponseHome) -> Unit
) {

    Column(
        modifier = Modifier
            .width(150.dp)
            .height(220.dp)
            .padding(horizontal = 10.dp)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null
            ) {
                onClick.invoke(item)
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray.copy(0.2f)),
            contentAlignment = Alignment.Center
        ) {

            if (item.rating != null && item.rating.rate > 0) {
                RatingView(item.rating.rate.toString(), modifier = Modifier.align(Alignment.TopEnd))
            }
            AsyncImage(
                model = item.image,
                contentDescription = item.title,
                contentScale = ContentScale.Fit,
                error = painterResource(R.drawable.ic_launcher_foreground)
            )

        }

        Spacer(Modifier.height(5.dp))
        Text(item.title, style = TextStyle(color = Color.Black, fontWeight = FontWeight.SemiBold), maxLines = 2, overflow = TextOverflow.Ellipsis)

        Spacer(Modifier.height(8.dp))
        CategoryView(item.category)

        Spacer(Modifier.height(8.dp))
        Text(
            "₹ ${item.price}", style = TextStyle(
                color = DarkGreen,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            ), maxLines = 1, overflow = TextOverflow.Ellipsis
        )

    }
}