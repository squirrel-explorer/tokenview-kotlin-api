/**
 * Specific runtime exception: illegal arguments
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.exception

class ApiIllegalArgumentsException(errCode: Int, errMsg: String): ApiRuntimeException(errCode, errMsg) {
    constructor(errMsg: String) : this(0, errMsg)
}
