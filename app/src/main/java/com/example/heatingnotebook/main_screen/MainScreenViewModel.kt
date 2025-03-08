package com.example.heatingnotebook.main_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.data.JournalRepository
import com.example.heatingnotebook.dialog.DialogController
import com.example.heatingnotebook.dialog.DialogEvent
import com.example.heatingnotebook.list_journala_screen.ListJournalEvent
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor( private val repository: JournalRepository
): ViewModel(), DialogController
{



    override var dialogTitle= mutableStateOf("Новый журнал")
        private  set
    override var textTitle = mutableStateOf("Название")
        private  set
    override var numberTitle= mutableStateOf("Номер")
        private  set
    override var editTableText= mutableStateOf("")
        private  set
    override var editNumber= mutableStateOf("")
        private  set
    override var openDialog = mutableStateOf(false)
        private  set
    override var showEditTableText= mutableStateOf(true)
        private  set
    override var existedId = mutableStateOf(false)
        private set

    fun onEvent(event: MainScreenEvent) {
        when( event ){
            is MainScreenEvent.OnItemSave -> {
                if(editTableText.value.isEmpty()) return
                if (editNumber.value.isEmpty()) editNumber.value = "0"
                viewModelScope.launch {
                    repository.insertItem(
                        Journal(
                        null,
                        editTableText.value,
                        editNumber.value
                    )
                    )
                }

            }
            is MainScreenEvent.OnShowEditDialog -> {
                openDialog.value = true

            }
        }

    }

    override  fun onDialogEvent(event: DialogEvent){
        when (event){

            is DialogEvent.OnTextChange -> {
                editTableText.value = event.text
            }

            is DialogEvent.OnTextNumberChange -> {
                editNumber.value = event.text
            }
            is DialogEvent.OnCancel -> {
                openDialog.value = false
                editTableText.value = ""
                editNumber.value = ""
            }
            is DialogEvent.OnConfirm -> {
                    onEvent(MainScreenEvent.OnItemSave)
                openDialog.value = false
                editTableText.value = ""
                editNumber.value = ""
            }

        }
    }
}