package com.example.heatingnotebook.main_screen

import  com.example.heatingnotebook.R
import com.example.heatingnotebook.utils.Routes

sealed class BottomNavItem (val title:String, val iconId: Int, val route:String){
    object Journals:BottomNavItem("Журналы", R.drawable.list_icon, Routes.JOURNALS_LIST)
    //object NoteItem:BottomNavItem("Создать", R.drawable.create_icon,Routes.NEW_JOURNAL)
    object AboutItem:BottomNavItem("Инфo", R.drawable.about_icon,Routes.ABOUT)
    object SettingItem:BottomNavItem("Настройки", R.drawable.settings_icon,Routes.SETTINGS)
}
