package com.example.heatingnotebook.list_journala_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heatingnotebook.data.Journal
import com.example.heatingnotebook.ui.theme.HardRed
import com.example.heatingnotebook.ui.theme.OrangeLight
import  com.example.heatingnotebook.R

@Composable
fun JournalCard(journal: Journal) {
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

        Row(
            Modifier
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    top = 5.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.Start,

                )

            {
                Text(
                    text = journal.name,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        start = 10.dp
                    ),
                    style = TextStyle(fontSize = 28.sp),
                    color = Color.Black
                )
                Text(
                    text = journal.number,
                    modifier = Modifier.padding(
                        top = 7.dp,
                        start = 10.dp,
                        bottom = 7.dp
                    ),
                    style = TextStyle(fontSize = 23.sp),
                    color = HardRed, fontWeight = FontWeight.Bold
                )


            }
            Row(
                modifier = Modifier.padding(
                    5.dp,
                )
            )
            {

                IconButton(
                    onClick = {
                    },
                )
                {
                    Icon(
                        painter = painterResource(id = R.drawable.edit_red),
                        contentDescription = "delete",
                        modifier = Modifier
                            .clip(CircleShape)
                            .padding(2.dp),
                        tint = HardRed
                    )
                }
                IconButton(
                    onClick = {
                    },
                )
                {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "delete",
                        modifier = Modifier
                            .clip(CircleShape)
                            .padding(2.dp),
                        tint = HardRed
                    )
                }
            }
        }
    }
}