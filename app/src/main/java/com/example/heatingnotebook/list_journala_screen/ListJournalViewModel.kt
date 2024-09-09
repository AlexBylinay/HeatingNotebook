package com.example.heatingnotebook.list_journala_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.data.JournalRepository
import com.example.heatingnotebook.dialog.DialogEvent
import com.example.heatingnotebook.dialog.DialogController
import com.example.heatingnotebook.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListJournalViewModel @Inject constructor(
    private val repository: JournalRepository,

    ) : ViewModel(), DialogController {

    val listJournal = repository.getAllItems()
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


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
    //  override var showEditTableNameText= mutableStateOf(false)
    //    private  set

    var journal: Journal? = null

    fun onEvent(event: ListJournalEvent) {
        when (event) {
            is ListJournalEvent.OnItemSave -> {
                viewModelScope.launch {
                    repository.insertItem(
                        Journal(
                            journal?.id,
                            editTableText.value,
                            editNumber.value
                        )
                    )
                }

            }

            is ListJournalEvent.OnItemClick -> {
                sendUiEvent(UiEvent.Navigate(event.route))
            }

            is ListJournalEvent.OnShowDeleteDialog -> {
                journal = event.journal
                openDialog.value = true
                dialogTitle.value = "Удалить Журнал?"
                showEditTableText.value = false
                //  showEditTableNameText.value = false

            }

            is ListJournalEvent.OnShowEditDialog -> {
                journal = event.journal
                openDialog.value = true
                editTableText.value = journal?.name ?: ""
                editNumber.value = journal?.number ?: ""
                dialogTitle.value = "Редактирование Журнала"
                showEditTableText.value = true
                //   showEditTableNameText.value = true

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
                    onEvent(ListJournalEvent.OnItemSave)
                } else {
                    viewModelScope.launch {
                        journal?.let { repository.deleteJournal(it) }
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