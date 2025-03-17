package com.task.zoondia.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchView(
    query : String,
    onValueChange : (String) -> Unit
) {


    OutlinedTextField(
        value = query,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .padding(top = 10.dp)
            .clip(RoundedCornerShape(10))
            .border(width = 2.dp, color = Color.Gray, RoundedCornerShape(10))
            .background(Color.Gray.copy(0.1f)),
        leadingIcon = {
            Icon(Icons.Rounded.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = "Search you items..", fontSize = 12.sp)
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        )
    )
}