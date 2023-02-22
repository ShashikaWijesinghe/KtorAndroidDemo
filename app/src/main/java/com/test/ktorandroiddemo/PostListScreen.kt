package com.test.ktorandroiddemo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PostListScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    val state = viewModel.postListState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(state.posts) { post ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.loadComments(post.id)
                            navController.navigate(Screen.CommentsListScreen.route)
                        }
                        .padding(15.dp)
                ) {
                    Text(
                        text = "#${post.id} ${post.title}",
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )
                    Text(
                        text = post.body,
                        fontSize = 14.sp
                    )
                }
                Divider()
            }
        }

        if(state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
