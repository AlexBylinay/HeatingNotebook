package com.example.heatingnotebook.list_journala_screen

import com.example.heatingnotebook.data.Journal

sealed class ListJournalEvent {
    data class OnShowDeleteDialog(val journal: Journal):ListJournalEvent()
    data class OnShowEditDialog(val journal: Journal):ListJournalEvent()
    data class OnItemClick (val route: String):ListJournalEvent()
    object OnItemSave:ListJournalEvent()

}