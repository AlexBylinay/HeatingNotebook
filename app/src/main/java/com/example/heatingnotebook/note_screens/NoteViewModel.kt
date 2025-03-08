package com.example.heatingnotebook.note_screens

import android.annotation.SuppressLint
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
import com.example.heatingnotebook.utils.Routes
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(), DialogController {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    var notes: Flow<List<Note>>? = null
    var note: Note? = null
    var listId: Int = 1
    var journalId: Int = -2
        private set


    var noteList by mutableStateOf(listOf<Note>())

  var journalIdForNewScreen= mutableStateOf(journalId)

    var note2 = mutableStateOf(
        Note(
            null, "", "", "0.00",
            "0.00", "0.00", "0.00", "0.00",
            "0.00", "0.00", "0.00",
            "0.00",
            "0.00", "0.00", "0.00", "0.00", journalId
        )
    )


    init {

        journalId = savedStateHandle.get<String>("journalId")?.toInt()!!
        Log.d("MyLog", "List id View model $journalId")
        journalIdForNewScreen.value = journalId
       notes = repository.getAllNoteByJournalId(journalId)

        viewModelScope.launch { notes?.collect{
                list ->
            noteList = list

        } }

    }

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

    override var numberTitle = mutableStateOf("")

    override var editTableText = mutableStateOf("")

    override var editNumber = mutableStateOf("")

    override var dialogTitle = mutableStateOf("")

    override var openDialog = mutableStateOf(false)

    override var showEditTableText = mutableStateOf(false)

    override var existedId = mutableStateOf(false)






    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.OnNoteSave -> {
                viewModelScope.launch {
                    if (listId == -1) return@launch
                    repository.insertNote(
                        Note(
                            null, getCurrentData(), getCurrentTime(), amountHeat1.value,
                            amount1.value, instantFlow1.value, temperature1.value, timeWork1.value,
                            amountHeat2.value, amount2.value, instantFlow2.value,
                            temperature2.value,
                            timeWork2.value, tempHot.value, tempHotIm.value, timeWorkWrong.value, journalId
                        )
                    )
                }
            }

            is NoteEvent.OnShowChangeScreen -> {

            }

            is NoteEvent.OnTextChange -> {



            }

            is NoteEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is NoteEvent.OnShowDeleteDialog -> {
                note = event.note
                openDialog.value = true
                dialogTitle.value = "Удалить Запись?"
                showEditTableText.value = false
                //  showEditTableNameText.value = false
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
                          note?.let { repository.deleteNote(it) }
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

    fun changeNote(note: Note){
         amountHeat1.value = note.amountHeat1
         amount1.value = note.amount1
         instantFlow1.value = note.instantFlow1
         temperature1.value = note.temperature1
        timeWork1.value = note.timeWork1

         amountHeat2.value = note.amountHeat2
         amount2.value = note.amount1
         instantFlow2.value = note.instantFlow2
         temperature2.value = note.temperature2
         timeWork2.value = note.timeWork2

         tempHot.value = note.tempHot
         tempHotIm.value = note.tempHotIm
         timeWorkWrong.value = note.timeWorkWrong
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentData():String{
        val sdf = SimpleDateFormat("dd/M/yyyy")
        return sdf.format(Date())
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentTime():String{
        val sdf = SimpleDateFormat("HH:mm:ss")
        return sdf.format(Date())
    }
}