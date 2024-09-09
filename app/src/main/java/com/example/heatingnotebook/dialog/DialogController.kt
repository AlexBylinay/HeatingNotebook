package com.example.heatingnotebook.dialog

import androidx.compose.runtime.MutableState

interface DialogController {
    val dialogTitle: MutableState<String>
    val textTitle: MutableState<String>
    val numberTitle: MutableState<String>
    val editTableText: MutableState<String>
    val editNumber: MutableState<String>
    val openDialog: MutableState<Boolean>
    val showEditTableText: MutableState<Boolean>
    //val showEditTableNameText: MutableState<Boolean>
    fun onDialogEvent(event: DialogEvent)


}