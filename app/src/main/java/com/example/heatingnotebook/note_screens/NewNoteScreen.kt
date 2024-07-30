package com.example.heatingnotebook.note_screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heatingnotebook.ui.theme.OrangeLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteScreen() {
    var text by remember { mutableStateOf("") }

    val heightTextFields by remember {
        mutableStateOf(80.dp)
    }

    val modifierTextField = Modifier
        .fillMaxWidth()
        .padding(8.dp)


    Card(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 3.dp),
        colors = CardDefaults.cardColors(
            containerColor = OrangeLight,
        ),
        shape = RoundedCornerShape(10.dp)

    ) {

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start,

            )

        {

            Text(
                text = "Ввидите данные:",
                modifier = Modifier.padding(
                    top = 10.dp,
                    start = 10.dp
                ),
                style = TextStyle(fontSize = 24.sp),
                color = Color.Black
            )

            TextField(
              modifier = modifierTextField,
                value = text,
                label = { Text(text = "Number Input Type",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black)

                },
                onValueChange = { it ->
                    text = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                textStyle = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 20.sp
                ),

                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            )

            OutlinedTextField(
                modifier = modifierTextField,
                value = text,
                label = { Text(text = "Number Input Type")
                },
                placeholder = { Text(text = "Enter your e-mail") },
                onValueChange = {
                    text = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            OutlinedTextField(
                modifier = modifierTextField,
                value = text,

                onValueChange = {
                    text = it
                },
                textStyle = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 22.sp
                ),

                label = { Text(text = "Email address",
                    style = TextStyle(fontSize = 20.sp),
                    color = Color.Black) },
                placeholder = { Text(text = "Enter your e-mail") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }





        }
    }



