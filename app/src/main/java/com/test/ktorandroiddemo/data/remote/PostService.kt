package com.test.ktorandroiddemo.data.remote

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface PostService {

    //get all posts
    suspend fun getPosts() : List<Post>

    //get comments for the give post
    suspend fun getComments(postId: Int) : List<Comment>

    companion object {
        fun create() : PostService {
            return PostServiceImpl(
                client = HttpClient(Android){
                    install(Logging) {
                        level = LogLevel.ALL
                    }

                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }

                    install(HttpTimeout) {
                        requestTimeoutMillis = 10000
                        connectTimeoutMillis = 10000
                        socketTimeoutMillis = 10000
                    }
                }
            )
        }
    }
}