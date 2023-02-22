package com.test.ktorandroiddemo.data.remote

import io.ktor.client.*
import io.ktor.client.request.*

class PostServiceImpl(
    private val client: HttpClient
) : PostService {

    override suspend fun getPosts(): List<Post> {
        return try {
            client.get {
                url(URLEndpoints.POSTS)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getComments(postId: Int): List<Comment> {
        return try {
            client.get {
                url(URLEndpoints.COMMENTS)
                parameter(
                    key = "postId",
                    value = postId
                )
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}