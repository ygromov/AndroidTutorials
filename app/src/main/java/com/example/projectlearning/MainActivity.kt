package com.example.projectlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.projectlearning.navigation.Navigtion
import com.example.projectlearning.presentation.heroesScreen.HeroicListState
import com.example.projectlearning.presentation.heroesScreen.MainViewModel
import com.example.projectlearning.ui.theme.ProjectLearningTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel = viewModel()

            ProjectLearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Navigtion(navHostController = navController)
                    //PersonScreen(heroicListState = viewModel.state.value)
                }
            }
        }
    }
}

//1  - build gradle implementation
//     dependencies {
//        classpath "com.google.dagger:hilt-android-gradle-plugin:2.40.5"
//     }
//2 - implementation "com.google.dagger:hilt-android:2.42"
//    kapt "com.google.dagger:hilt-android-compiler:2.42"
//    kapt "androidx.hilt:hilt-compiler:1.0.0"
//    kapt "org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.4.2"
//    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0-alpha03'
//3 - id 'kotlin-kapt'
//    id 'dagger.hilt.android.plugin'
//4 - creating instance of BaseApplication
//5 - Manifest File - android:name=".BaseApplication"