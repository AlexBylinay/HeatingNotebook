package com.example.heatingnotebook.settings_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen() {
    Text(
        text = "SettingsScreen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )
}