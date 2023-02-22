package com.test.ktorandroiddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.ktorandroiddemo.ui.theme.KtorAndroidDemoTheme

class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            KtorAndroidDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PostListScreen.route
                    ){
                        composable(
                            route = Screen.PostListScreen.route
                        ) {
                            PostListScreen(navController, viewModel)
                        }

                        composable(
                            route = Screen.CommentsListScreen.route
                        ) {
                            CommentListScreen(viewModel)
                        }
                    }
                }
            }

        }
    }
}

