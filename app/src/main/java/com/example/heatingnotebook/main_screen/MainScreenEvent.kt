package com.example.heatingnotebook.main_screen

sealed class MainScreenEvent {
    data object OnItemSave : MainScreenEvent()
   data object OnShowEditDialog: MainScreenEvent()


}