package com.example.projectlearning.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import com.example.projectlearning.MainActivity
import com.example.projectlearning.presentation.heroesScreen.HeroicEvent
import com.example.projectlearning.presentation.heroesScreen.HeroicListState
import com.example.projectlearning.presentation.heroesScreen.components.IsLoading
import com.example.projectlearning.presentation.heroesScreen.components.IsNotBlank
import com.example.projectlearning.presentation.heroesScreen.components.PersonItem
import com.example.projectlearning.utils.Routers

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroesScreen(
    navController: NavController,
    heroicListState: HeroicListState,
    onEvent: (HeroicEvent) -> Unit
) {

    Scaffold {
        IsLoading(state = heroicListState)
        IsNotBlank(state = heroicListState)

        PersonItem(
            endIsReached = heroicListState.endIsReached,
            persons = heroicListState.persons,
            onClick = { personId ->
                navController.navigate(Routers.PersonScreen.route + "/$personId")
                //+ "/$it")
            },

//            val toast = Toast.makeText(MainActivity().applicationContext,"delete",Toast.LENGTH_SHORT)
//        toast.show()
//            onClick1 = { personId ->
//                navController.navigate(Routers.TestScreen.route + "/$personId")
////                val toast = Toast.makeText(requireContext(),"delete",Toast.LENGTH_SHORT)
////                toast.show()
//            },
            onEvent = onEvent
        )
    }
}