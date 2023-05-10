package com.example.projectlearning.presentation.heroesScreen.components

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.projectlearning.MainActivity
import com.example.projectlearning.domain.model.Person
import com.example.projectlearning.presentation.heroesScreen.HeroicEvent

@Composable
fun PersonCard(person: Person, onClick: (id: Int) -> Unit, onEvent:(HeroicEvent)->Unit) {
    //onEvent1:(HeroicEvent) -> Unit
//    var stateB = remember{ mutableStateOf("Delete")}
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(modifier = Modifier
            .padding(start = 10.dp, top = 8.dp)
            .clickable { onClick.invoke(person.id) }
        ) {
            Text(text = person.name)
        }
        Card(modifier = Modifier
            .padding(top = 8.dp, end = 10.dp)
            .clickable { }) {
            Text(text = person.status)
        }
        OutlinedButton(
            onClick = {
                   onEvent.invoke(HeroicEvent.DelPerson(person))
//                stateB. value="pressed"
            },
            Modifier.background(color = Color.White)
        ) {
            Text(
                text = "Delete",//stateB.value,
                color = Color.Black
            )

        }
    }
}
