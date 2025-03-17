@file:OptIn(ExperimentalMaterial3Api::class)

package com.task.zoondia.features.details.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.task.zoondia.R
import com.task.zoondia.features.home.presentation.components.CategoryView
import com.task.zoondia.features.home.presentation.components.RatingView
import com.task.zoondia.navigation.Destinations
import com.task.zoondia.navigation.LocalNavController
import com.task.zoondia.ui.theme.DarkGreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(itemDetail: Destinations.NavDetailScreen) {

    val navController = LocalNavController.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.AutoMirrored.Rounded.KeyboardArrowLeft, contentDescription = "back_button")
                    }
                },
                title = {
                    Text(text = itemDetail.title, fontSize = 13.sp, maxLines = 1, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.SemiBold)
                },
                actions = {
                    IconButton(
                        onClick = {
                        }) {
                        Icon(Icons.Rounded.Share, contentDescription = "back_button", modifier = Modifier.size(20.dp))
                    }
                }
            )
        }
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {

            AsyncImage(
                model = itemDetail.image,
                contentDescription = itemDetail.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 20.dp),
                error = painterResource(R.drawable.ic_launcher_background)
            )

            Spacer(Modifier.height(20.dp))
            Text(text = itemDetail.description, fontSize = 14.sp, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.SemiBold)


            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CategoryView(itemDetail.category)
                RatingView("${itemDetail.rating} "+"(${itemDetail.totalRating})")

            }

            Spacer(Modifier.height(10.dp))
            Text(
                "₹ ${itemDetail.price}", style = TextStyle(
                    color = DarkGreen,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                ), maxLines = 1, overflow = TextOverflow.Ellipsis
            )
        }


    }
}