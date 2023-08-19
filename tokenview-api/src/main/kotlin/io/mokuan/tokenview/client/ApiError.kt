/**
 * Wrapper for API client error
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

object ApiError {
    // The response body is null
    val bodyIsNull = Error(1001,"Response body is null")
    //http status code 不是 成功
    val httpStatusCodeError = Error(1002,"Server error")
    //未知异常
    val unknownException = Error(1099,"Unknown exception")
}

data class Error(val errorCode:Int,val errorMsg:String)
