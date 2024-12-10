package com.example.heatingnotebook.note_screens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.data.NoteRepository
import com.example.heatingnotebook.dialog.DialogController
import com.example.heatingnotebook.dialog.DialogEvent
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(), DialogController {
    private val _uiEvent = Channel<UiEvent>()

    val uiEvent = _uiEvent.receiveAsFlow()

    var noteList: Flow<List<Note>>? = null

    //var note: Note? = null
    var shoppingListItem: Journal? = null
    var listId: Int = -1
    var journalId: Int = -1

    init {
        journalId = savedStateHandle.get<String>("journalId")?.toInt()!!
        Log.d("MyLog", "List id View model $journalId")

        noteList = repository.getAllNoteByJournalId(journalId!!)
    }

    // itemsList = repository.getAllItemsByID(listId)
    //viewModelScope.launch { shoppingListItem = repository.getListItemsByID(listId) }

    var note = mutableStateOf(
        Note(
            null, "", "", "",
            "", " ", "", "",
            "", "", "",
            "",
            "", "", "", " ", 30
        )
    )
    var amountHeat1 = mutableStateOf("")
    var amount1 = mutableStateOf("")
    var instantFlow1 = mutableStateOf("")
    var temperature1 = mutableStateOf("")
    var timeWork1 = mutableStateOf("")
    var amountHeat2 = mutableStateOf("")

    var amount2 = mutableStateOf("")
    var instantFlow2 = mutableStateOf("")
    var temperature2 = mutableStateOf("")
    var timeWork2 = mutableStateOf("")

    var tempHot = mutableStateOf("")
    var tempHotIm = mutableStateOf("")
    val timeWorkWrong = mutableStateOf("")

    override var textTitle = mutableStateOf("")
        private set
    override var numberTitle = mutableStateOf("")
        private set
    override var editTableText = mutableStateOf("")
        private set
    override var editNumber = mutableStateOf("")
        private set
    override var dialogTitle = mutableStateOf("")
        private set
    override var openDialog = mutableStateOf(false)
        private set
    override var showEditTableText = mutableStateOf(false)
        private set
    override var existedId = mutableStateOf(false)
        private set


    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.OnNoteSave -> {
                viewModelScope.launch {
                    if (listId == -1) return@launch
                    repository.insertNote(
                        Note(
                            4, "12.09.2024", "11:34", "99879.110",
                            "0.78", "1.7", "56.2", "34:78",
                            "99879.110", "0.78", "1.7",
                            "46.2",
                            "34:78", "10.0", "5.0", " 2:13", journalId
                        )
                    )
                }
            }

            is NoteEvent.OnShowDEventDialog -> {

            }

            is NoteEvent.OnTextChange -> {


            }

            is NoteEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is NoteEvent.OnShowDeleteDialog -> TODO()

            is NoteEvent.OnItemClick -> {
            }
        }


    }


    override fun onDialogEvent(event: DialogEvent) {
        when (event) {

            is DialogEvent.OnTextChange -> {
                editTableText.value = event.text
            }

            is DialogEvent.OnTextNumberChange -> {
                editNumber.value = event.text
            }

            is DialogEvent.OnCancel -> {
                openDialog.value = false
            }

            is DialogEvent.OnConfirm -> {
                if (showEditTableText.value) {
                    //  onEvent(ListJournalEvent.OnItemSave)
                } else {
                    viewModelScope.launch {
                        //  journal?.let { repository.deleteJournal(it) }
                    }
                    openDialog.value = false
                }
                openDialog.value = false
            }

        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}