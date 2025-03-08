package com.example.heatingnotebook.see_note_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.heatingnotebook.ui.theme.OrangeLight

@Composable
fun NoteScreen(modifier: Modifier = Modifier,
    viewModel: SeeNoteViewModel = hiltViewModel()) {

    val modifierText =Modifier.padding(top = 8.dp, start = 6.dp)
    val modifierTextCap =Modifier.padding(end = 12.dp, start = 12.dp)
    val styleText = TextStyle(fontSize = 21.sp)
    val styleTextCap = TextStyle(fontSize = 25.sp)

val note  = viewModel.note2.value
    Card(
        modifier = modifier

    )
    {
        Card(
            modifier = Modifier.
                fillMaxWidth()
                .padding(
                    start = 4.dp, end = 4.dp
                ).verticalScroll(rememberScrollState()),
            colors = CardDefaults.cardColors(
                containerColor = OrangeLight,
            )

        ) {
            Column(
                modifier = Modifier.fillMaxSize()

            ) {

                Text(
                    text = "Дата снятия показаний:  ${note?.data} ",
                    modifierText,
                    style = styleText
                )
                Text(
                    text = "Время снятия показаний:  ${note?.time} ",
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
                        text = "Показания прибора учета тепла (Q):   ${note?.amountHeat1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Разница паказаний: ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Объём (V),м3:  ${note?.amount1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Мгновенный расход (G), м3/ч: ${note?.instantFlow1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Температура (t),°С: ${note?.temperature1} ",
                        modifierText,
                        style = styleText
                    )
                    Text(
                        text = "Время работы прибора (Тобщ),час: ${note?.timeWork1} ",
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
                        text = "Показания прибора учета тепла (Q):   ${note?.amountHeat2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Разница паказаний: ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Объём (V),м3:  ${note?.amount2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Мгновенный расход (G),м3/ч: ${note?.instantFlow2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Температура (t),°С: ${note?.temperature2} ",
                        modifierText,
                        style = styleText

                    )
                    Text(
                        text = "Время работы прибора (Тобщ),час: ${note?.timeWork2} ",
                        modifierText,
                        style = styleText

                    )

                }
                Text(
                    text = "id: ${note?.id} ",
                    modifierText,
                    style = styleText

                )

                Text(
                    text = "Температура холодной воды(t),°С: ${note?.tempHot}",
                    modifierText,
                    style = styleText
                )
                Text(
                    text = "Температура холодной воды иммитатор (t),°С: ${note?.tempHotIm} ",
                    modifierText,
                    style = styleText

                )
                Text(
                    text = "Время работы прибора с ошибкой (Тош.),час: ${note?.timeWorkWrong} ",
                    modifierText,
                    style = styleText
                )

            }
        }
    }
}