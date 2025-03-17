package com.task.zoondia.features.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.task.zoondia.common.SkeletonView

@Composable
fun ShimmerHome() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        SkeletonView(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )

        Spacer(Modifier.height(20.dp))

        repeat(10) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {

                    SkeletonView(
                        modifier = Modifier
                            .width(150.dp)
                            .height(110.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    SkeletonView(
                        modifier = Modifier
                            .width(110.dp)
                            .height(10.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                    SkeletonView(
                        modifier = Modifier
                            .width(90.dp)
                            .height(10.dp)
                    )

                    Spacer(Modifier.height(4.dp))
                    SkeletonView(
                        modifier = Modifier
                            .width(70.dp)
                            .height(10.dp)
                    )

                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {

                    SkeletonView(
                        modifier = Modifier
                            .width(150.dp)
                            .height(110.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    SkeletonView(
                        modifier = Modifier
                            .width(110.dp)
                            .height(10.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                    SkeletonView(
                        modifier = Modifier
                            .width(90.dp)
                            .height(10.dp)
                    )

                    Spacer(Modifier.height(4.dp))
                    SkeletonView(
                        modifier = Modifier
                            .width(70.dp)
                            .height(10.dp)
                    )

                }

            }
        }
    }
}