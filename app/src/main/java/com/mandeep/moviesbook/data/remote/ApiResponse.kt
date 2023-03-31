package com.mandeep.moviesbook.data.remote

/**
 * App Name: Movies Book
 * Package Name: com.mandeep.moviesbook.data.remote
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Fri 31 Mar, 2023
 *
 **/
sealed class ApiResponse<out T> {
    data class Success<out T>(val statusCode: Int, val data: T?) : ApiResponse<T>()
    data class Failure<out T>(val statusCode: Int, val error: String) : ApiResponse<T>()
    data class UnAuthorization<out T>(val statusCode: Int, val error: String) : ApiResponse<T>()
}
