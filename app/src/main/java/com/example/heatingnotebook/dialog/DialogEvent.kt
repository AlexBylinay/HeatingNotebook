package com.example.heatingnotebook.dialog

sealed class DialogEvent {
    data class OnTextChange(val text: String):DialogEvent()
    data class OnTextNumberChange(val text: String):DialogEvent()
    data object OnCancel: DialogEvent()
    data object OnConfirm: DialogEvent()


}