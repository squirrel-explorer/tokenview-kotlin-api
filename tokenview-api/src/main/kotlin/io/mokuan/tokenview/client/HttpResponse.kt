/**
 * Wrapper for lite HTTP response
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

class HttpResponse {
    var code = 0
    var msg = ""
    var errorCode = 0
    var errorMessage = ""

    override fun toString(): String {
        return "HttpResponse { code = $code, msg = $msg, errorCode = $errorCode, errorMessage = $errorMessage }"
    }
}