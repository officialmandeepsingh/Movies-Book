package com.mandeep.moviesbook.data.remote

import org.json.JSONObject
import retrofit2.Response

/**
 * App Name: Movies Book
 * Package Name: com.mandeep.moviesbook.data.remote
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Fri 31 Mar, 2023
 *
 **/
object NetworkRequest {
    suspend fun <T> request(api: suspend () -> Response<T>): ApiResponse<T> {
        try {
            val response = api()
            val body = response.body()
            val statusCode = response.code()
            return when (statusCode) {
                in 201..299 -> {
                    ApiResponse.Success(statusCode, body)
                }
                404 -> {
                    val errorResponse = response.errorBody()?.string() ?: "{}"
                    val json = JSONObject(errorResponse)
                    val message = json.optString("message")
                    ApiResponse.UnAuthorization(statusCode, message)
                }
                else -> {
                    val errorResponse = response.errorBody()?.string() ?: "{}"
                    val json = JSONObject(errorResponse)
                    val message = json.optString("message")
                    ApiResponse.Failure(statusCode, message)
                }
            }
        } catch (exception: Exception) {
            return ApiResponse.Failure(401,exception.message?:"Something went wrong")
        }
    }
}