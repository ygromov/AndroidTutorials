package com.example.projectlearning.presentation.personScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun PersonScreen(navController: NavController, personState: PersonState, person: PersonState) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Card() {
            AsyncImage(model = person.image, contentDescription = "avatarCharacter")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            //horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(modifier = Modifier
                .fillMaxWidth(0.5f)) {
                Text(text = "Name", fontWeight = FontWeight(800), textAlign = TextAlign.Center)
            }
            Card(modifier = Modifier
                .fillMaxWidth()) {
                Text(text = person.name, textAlign = TextAlign.Center)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Card(modifier = Modifier
                .fillMaxWidth(0.5f)) {
                Text(text = "Status", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
            Card(modifier = Modifier
                .fillMaxWidth()) {
                Text(text = person.species, textAlign = TextAlign.Center)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
            //horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Card(modifier = Modifier
                .fillMaxWidth(0.5f)) {
                Text(text = "Species", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            }
            Card(modifier = Modifier
                .fillMaxWidth()) {
                Text(text = person.status, textAlign = TextAlign.Center)
            }
        }

    }
}