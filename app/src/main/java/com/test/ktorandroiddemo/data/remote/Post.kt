package com.test.ktorandroiddemo.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val body: String,
    val title: String,
    val id: Int,
    val userId: Int
)
