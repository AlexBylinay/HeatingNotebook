package com.example.heatingnotebook.about_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen() {
    Text(
        text = "AboutScreen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )

}