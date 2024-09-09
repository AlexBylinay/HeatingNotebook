package com.example.heatingnotebook.utils

sealed class UiEvent{
    data object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class NavigateMain(val route: String): UiEvent()
    data class ShowShackBar(val message: String): UiEvent()
}