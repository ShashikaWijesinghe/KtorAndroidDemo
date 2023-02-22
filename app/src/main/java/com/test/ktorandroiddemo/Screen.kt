package com.test.ktorandroiddemo

sealed class Screen(val route: String) {
    object PostListScreen : Screen("post_list_screen")
    object CommentsListScreen : Screen("comments_list_screen")
}
