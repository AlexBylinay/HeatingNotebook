package com.example.heatingnotebook.note_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.heatingnotebook.R
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.main_screen.BottomNav
import com.example.heatingnotebook.main_screen.MainScreenEvent
import com.example.heatingnotebook.ui.theme.Orange
import com.example.heatingnotebook.ui.theme.OrangeLight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteScreen(viewModel: NoteViewModel = hiltViewModel(), onPopBackStack: () -> Unit) {


    val note = Note(
        4, "12.09.2024", "11:34", "99879.110",
        "0.78", "1.7", "56.2", "34:78",
        "99879.110", "0.78", "1.7",
        "46.2",
        "34:78", "10.0", "5.0", " 2:13", 30
    )


    var text by remember { mutableStateOf("") }


    val modifierText = Modifier.padding(
        top = 20.dp,
        start = 10.dp
    )

    val textStyle =
        TextStyle(fontSize = 24.sp, color = Color.Black)

    val modifierOutlinedTextField = Modifier
        .fillMaxWidth()
        .padding(8.dp)

    val outlinedTextFieldPlaceholderstyle = TextStyle(fontSize = 20.sp, color = Color.Black)

    val outlinedTextFieldTextStyle = TextStyle(
        color = Color.DarkGray, fontSize = 22.sp
    )

    val keyboardNum = KeyboardOptions(keyboardType = KeyboardType.Number)

    val placeholderTxt = "Последние паказания: "

    Card(
        onClick = { },
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 30.dp, bottom = 100.dp,
                start = 5.dp, end = 5.dp
            )
            .verticalScroll(rememberScrollState()),
        colors = CardDefaults.cardColors(
            containerColor = OrangeLight,
        ),
        shape = RoundedCornerShape(10.dp)

    ) {

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start

            )
        {

            Text(
                text = "Ввидите данные:",
                modifierText,
                style = textStyle
            )


            Text(
                text = "Подающий трубопровод:",
                modifierText,
                style = textStyle
            )



            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.amountHeat1.value,
                onValueChange = {
                    viewModel.amountHeat1.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Показания прибора учета тепла (Q)",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.amountHeat1) },
                keyboardOptions = keyboardNum
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.amount1.value,
                onValueChange = {
                    viewModel.amount1.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Объём (V),м3",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.amount1) },
                keyboardOptions = keyboardNum
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.instantFlow1.value,
                onValueChange = {
                    viewModel.instantFlow1.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Мгновенный расход (G), м3/ч",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.instantFlow1) },
                keyboardOptions = keyboardNum
            )
            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.temperature1.value,
                onValueChange = {
                    viewModel.temperature1.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Температура (t),°С",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.temperature1) },
                keyboardOptions = keyboardNum
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.timeWork1.value,
                onValueChange = {
                    viewModel.timeWork1.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Время работы прибора (Тобщ),час",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.timeWork1) },
                keyboardOptions = keyboardNum
            )


            Text(
                text = "Обратный трубопровод:",
                modifierText,
                style = textStyle
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.amountHeat2.value,
                onValueChange = {
                    viewModel.amountHeat2.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Показания прибора учета тепла (Q)",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.amountHeat2) },
                keyboardOptions = keyboardNum
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.amount2.value,
                onValueChange = {
                    viewModel.amount2.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Объём (V),м3",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.amount2) },
                keyboardOptions = keyboardNum
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.instantFlow2.value,
                onValueChange = {
                    viewModel.instantFlow2.value =it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Мгновенный расход (G), м3/ч",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.instantFlow2) },
                keyboardOptions = keyboardNum
            )
            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.temperature2.value,
                onValueChange = {
                    viewModel.temperature2.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Температура (t),°С",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.temperature2) },
                keyboardOptions = keyboardNum
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.timeWork2.value,
                onValueChange = {
                    viewModel.timeWork2.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Время работы прибора (Тобщ),час",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.timeWork2) },
                keyboardOptions = keyboardNum
            )

            Text(
                text = "Температура холодной воды",
                modifierText,
                style = textStyle
            )


            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.tempHot.value,
                onValueChange = {
                    viewModel.tempHot.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "показания датчика",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.tempHot) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.tempHotIm.value,
                onValueChange = {
                    viewModel.tempHotIm.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "иммитатор (норматив)",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.tempHotIm) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            Text(
                text = "Дополнительно:",
                modifierText,
                style = textStyle
            )
            OutlinedTextField(
                modifier = modifierOutlinedTextField,
                value = viewModel.timeWorkWrong.value,
                onValueChange = {
                    viewModel.timeWorkWrong.value = it
                },
                textStyle = outlinedTextFieldTextStyle,
                label = {
                    Text(
                        text = "Время работы прибора с ошибкой (Тош.), час",
                        style = outlinedTextFieldPlaceholderstyle,
                    )
                },
                placeholder = { Text(text = placeholderTxt + note.timeWorkWrong) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )





        }

        Column(
            Modifier.fillMaxHeight(),
             horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.Bottom
            ) {


                Button(


                    onClick = { /* ... */ },
                    colors = ButtonDefaults.buttonColors(Orange),
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.add_icon
                        ),
                        contentDescription = "add",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Добвить")
                }
            }

        }


    }
}



