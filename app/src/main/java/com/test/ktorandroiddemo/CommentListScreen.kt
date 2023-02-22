package com.test.ktorandroiddemo

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

@Composable
fun CommentListScreen(
    viewModel: MainViewModel
) {
    val state = viewModel.commentListState.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(state.comments) { comment ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    Text(
                        text = "#${comment.id} ${comment.name}",
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier.height(5.dp)
                    )
                    Text(
                        text = comment.body,
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