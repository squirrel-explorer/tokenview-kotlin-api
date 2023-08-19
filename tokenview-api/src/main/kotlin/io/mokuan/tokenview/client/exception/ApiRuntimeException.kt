/**
 * Runtime exception for API
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.exception

open class ApiRuntimeException(val errCode: Int,
                               val errMsg: String): RuntimeException("ErrCode: $errCode, ErrMsg: $errMsg") {
    constructor(errMsg: String) : this(0, errMsg)
}