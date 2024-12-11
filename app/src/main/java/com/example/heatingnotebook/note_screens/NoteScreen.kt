package com.example.heatingnotebook.note_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.heatingnotebook.data.Note
import com.example.heatingnotebook.ui.theme.OrangeLight

@Composable
fun NoteScreen(viewModel: NoteViewModel = hiltViewModel()) {

    val modifierText =Modifier.padding(top = 8.dp, start = 5.dp)
    val modifierTextCap =Modifier.padding(end = 10.dp, start = 10.dp)
    val styleText = TextStyle(fontSize = 20.sp)
    val styleTextCap = TextStyle(fontSize = 23.sp)
val note = viewModel.note.value


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp,
                bottom = 100.dp, start = 5.dp, end = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = OrangeLight,)

    ) {
        Column(
            modifier = Modifier.fillMaxSize()

        ) {

            Text(
                text = "Дата снятия показаний:  ${note.data} ",
                modifierText,
                style = styleText
            )
            Text(
                text = "Время снятия показаний:  ${note.time} ",
                modifierText,
                style = styleText
            )


                Column(
                     modifier = Modifier.padding(top = 12.dp)
                ) {

                    Text(
                        text = "Подающий трубопровод: ",
                        modifierTextCap,
                        style = styleTextCap

                    )

                    Text(
                        text = "Показания прибора учета тепла (Q):   ${note.amountHeat1} ",
                                modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Разница паказаний: ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Объём (V),м3:  ${note.amount1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Мгновенный расход (G), м3/ч: ${note.instantFlow1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Температура (t),°С: ${note.temperature1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Время работы прибора (Тобщ),час: ${note.timeWork1} ",
                        modifierText,
                        style = styleText
                    )
                }




                Column(
                    modifier = Modifier.padding(top = 10.dp)
                ) {

                    Text(
                        text = "Обратный трубопровод: ",
                        modifierTextCap,
                        style = styleTextCap
                    )

                    Text(
                        text = "Показания прибора учета тепла (Q):   ${note.amountHeat2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Разница паказаний: ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Объём (V),м3:  ${note.amount2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Мгновенный расход (G),м3/ч: ${note.instantFlow2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Температура (t),°С: ${note.temperature2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Время работы прибора (Тобщ),час: ${note.timeWork2} ",
                        modifierText,
                        style = styleText

                    )

            }
            Text(
                text = "id: ${note.id} ",
                modifierText,
                style = styleText

            )

            Text(
                text = "Температура холодной воды(t),°С: ${note.tempHot}",
                modifierText,
                style = styleText
            )
            Text(
                text = "Температура холодной воды иммитатор (t),°С: ${note.tempHotIm} ",
                modifierText,
                style = styleText

            )
            Text(
                text = "Время работы прибора с ошибкой (Тош.),час: ${note.timeWorkWrong} ",
                modifierText,
                style = styleText
            )

        }
    }

}