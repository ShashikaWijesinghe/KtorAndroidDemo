package com.test.ktorandroiddemo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.ktorandroiddemo.data.remote.Comment
import com.test.ktorandroiddemo.data.remote.Post
import com.test.ktorandroiddemo.data.remote.PostService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val postService = PostService.create()

    private val _postListState = mutableStateOf(PostListState())
    val postListState : State<PostListState> = _postListState

    private val _commentListState = mutableStateOf(CommentListState())
    val commentListState : State<CommentListState> = _commentListState

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            val posts = postService.getPosts()
            _postListState.value = PostListState(
                isLoading = false,
                posts = posts
            )
        }
    }

    fun loadComments(postId: Int) {
        viewModelScope.launch {
            _commentListState.value = CommentListState()
            val comments  = postService.getComments(postId)
            _commentListState.value = CommentListState(
                isLoading = false,
                comments = comments
            )
        }
    }

}

data class PostListState(
    var isLoading: Boolean = true,
    var posts: List<Post> = emptyList()
)

data class CommentListState(
    var isLoading: Boolean = true,
    var comments: List<Comment> = emptyList()
)