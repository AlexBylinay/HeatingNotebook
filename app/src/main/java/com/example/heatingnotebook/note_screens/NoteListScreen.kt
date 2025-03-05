package com.example.heatingnotebook.note_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.heatingnotebook.R
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.dialog.MainDialog
import com.example.heatingnotebook.list_journala_screen.JournalCard
import com.example.heatingnotebook.main_screen.BottomNav
import com.example.heatingnotebook.main_screen.MainScreenEvent
import com.example.heatingnotebook.navigation.NavigationGraph
import com.example.heatingnotebook.ui.theme.Orange
import com.example.heatingnotebook.ui.theme.OrangeLight
import com.example.heatingnotebook.ui.theme.RedBlack
import com.example.heatingnotebook.utils.Routes
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteListScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {

    val journalId = viewModel.journalIdForNewScreen.value

    val list = viewModel.notes?.collectAsState(initial = emptyList())

    val note = Note(
        4, "12.09.2024", "11:34", "99879.110",
        "0.78", "1.7", "56.2", "34:78",
        "99879.110", "0.78", "1.7",
        "46.2",
        "34:78", "10.0", "5.0", " 2:13", 30
    )

    val note2 = Note(
        4, "12.09.2024", "11:34", "99879.110",
        "0.78", "1.7", "56.2", "34:78",
        "99879.110", "0.78", "1.7",
        "46.2",
        "34:78", "10.0", "5.0", " 2:13", 30
    )

    val notes = mutableListOf<Note>(note, note2,note, note2, note, note2,
        note, note2, note, note2, note2,note, note2, note, note2, note, note2,
        note2,note, note2, note, note2, note, note2, )

    val modifierText = Modifier.padding(
        start = 10.dp, end = 10.dp
    )

    val textStyle =
        TextStyle(//fontSize = 22.sp,
            color = RedBlack)

    // val lable = "Новая запись"

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


    Scaffold(
        modifier = modifier
    )

    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(top = 2.dp, bottom = 60.dp)
        )
        {
            items(list!!.value) { item ->
                NoteListCard(viewModel, item, journalId.toString()) { event ->
                    viewModel.onEvent(event)
                }
            }
        }
        Column(
            Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 6.dp),
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(

                    onClick = {
                        viewModel.onEvent(
                            NoteEvent.OnItemClick(
                                Routes.NEW_NOTE + "/${journalId}"
                            )
                        )
                    },
                    colors = ButtonDefaults.buttonColors(Orange),
                ) {
                    androidx.compose.material.Icon(
                        painter = painterResource(
                            id = R.drawable.add_icon
                        ),
                        contentDescription = "add",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    androidx.compose.material3.Text("Создать Запись")
                }

            }


        }
    }
    MainDialog(viewModel)
}