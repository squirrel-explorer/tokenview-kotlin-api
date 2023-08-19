/**
 * Wrapper for API response
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T): ApiResult<T>()
    data class Failure(val errorCode:Int, val errorMsg:String): ApiResult<Nothing>()
}
