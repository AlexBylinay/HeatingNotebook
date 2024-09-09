package com.example.heatingnotebook.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heatingnotebook.ui.theme.Orange
import com.example.heatingnotebook.ui.theme.RedBlack
import com.example.heatingnotebook.ui.theme.Yellow

@Composable
fun MainDialog(dialogController: DialogController) {
    if (dialogController.openDialog.value){
        AlertDialog(
            onDismissRequest = {
                dialogController.onDialogEvent(DialogEvent.OnCancel)
            },
            title = { null},
            text = {

                Column(modifier = Modifier.fillMaxWidth()) {


                    Text(
                        text = dialogController.dialogTitle.value,
                        style = TextStyle(
                            color = RedBlack,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    if (dialogController.showEditTableText.value)
                    {
                        TextField(
                            value = dialogController.editTableText.value,
                            onValueChange = { text ->
                                dialogController.onDialogEvent(DialogEvent.OnTextChange(text))
                            },
                            label = { Text(text = dialogController.textTitle.value) },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Yellow,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(8.dp),
                            singleLine = true,
                            textStyle = TextStyle(
                                color = Orange,
                                fontSize = 16.sp
                            )

                        )


                    Spacer(modifier = Modifier.height(10.dp))

                        TextField(
                            value = dialogController.editNumber.value,
                            onValueChange = { text ->
                                dialogController.onDialogEvent(DialogEvent.OnTextNumberChange(text))
                            },
                            label = { Text(text = dialogController.numberTitle.value) },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Yellow,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(8.dp),
                            singleLine = true,
                            textStyle = TextStyle(
                                color = Orange,
                                fontSize = 16.sp
                            )

                        )

                }}
            },


            confirmButton = {
                TextButton(onClick = {
                    dialogController.onDialogEvent(DialogEvent.OnConfirm)
                }) {

                    if (dialogController.showEditTableText.value)
                    Text(text = "Создать" )
else
                        Text(text = "Удалить" )
                }

            },
            dismissButton  = {
                TextButton(onClick = {
                    dialogController.onDialogEvent(DialogEvent.OnCancel)
                }) {
                    Text(text = "Отмена" )

                }

            }


        )
    }

}