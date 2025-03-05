package com.example.heatingnotebook.see_note_screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.data.NoteRepository
import com.example.heatingnotebook.dialog.DialogController
import com.example.heatingnotebook.note_screens.NoteEvent
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class SeeNoteViewModel @Inject constructor(
    private val repository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var note: Note? = null
    var noteId: Int = 5
    var note2 = mutableStateOf(note)
    var journalId = 1

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


    init {
        noteId = savedStateHandle.get<String>("noteId")?.toInt()!!

        viewModelScope.launch { note2.value = repository.getNoteById(noteId)

        if (note2.value != null){ journalId = note2.value!!.journalId


           amountHeat1.value = note2.value!!.amountHeat1
                  amount1.value = note2.value!!.amount1
            instantFlow1.value = note2.value!!.instantFlow1
            temperature1.value = note2.value!!.temperature1
            timeWork1.value = note2.value!!.timeWork1

            amountHeat2.value = note2.value!!.amountHeat2
            amount2.value = note2.value!!.amount2
            instantFlow2.value = note2.value!!.instantFlow2
            temperature2.value = note2.value!!.temperature2
            timeWork2.value = note2.value!!.timeWork2

            tempHot.value = note2.value!!.tempHot
            tempHotIm.value = note2.value!!.tempHot
            timeWorkWrong.value = note2.value!!.timeWorkWrong
        }
        }
    }

      var listId: Int = 1





    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.OnNoteSave -> {
                viewModelScope.launch {
                    repository.insertNote(
                        Note(
                            noteId, getCurrentData(), getCurrentTime(), amountHeat1.value,
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

            }

            is NoteEvent.OnShowDeleteDialog -> {

            }

        }


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