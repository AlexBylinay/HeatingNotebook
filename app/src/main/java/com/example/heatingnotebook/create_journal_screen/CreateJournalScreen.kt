package com.example.heatingnotebook.create_journal_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateJournalScreen() {
    Text(
        text = "CreateJournalScreen",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .wrapContentWidth()
    )
}