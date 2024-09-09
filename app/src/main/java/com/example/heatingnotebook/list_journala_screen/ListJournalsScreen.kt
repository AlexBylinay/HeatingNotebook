package com.example.heatingnotebook.list_journala_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.dialog.MainDialog
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ListJournalsScreen(viewModel: ListJournalViewModel = hiltViewModel(),
                       onNavigate: (String) -> Unit) {

    val list = viewModel.listJournal.collectAsState(initial = emptyList())

    LaunchedEffect(key1 = true )
    {
        viewModel.uiEvent.collect{uiEvent ->
            when (uiEvent){
                is UiEvent.Navigate ->{
                    onNavigate(uiEvent.route)
                }
                else ->{}
            }

        }
    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 110.dp)
    )
    {
        items(list.value) { item ->
            JournalCard(item) { event ->
                viewModel.onEvent(event)

            }
        }
    }
    MainDialog(viewModel)
}




