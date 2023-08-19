/**
 * Network exception for API
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.exception

import java.io.IOException

class ApiNetworkException(val errCode: Int, val errMsg: String): IOException() {
    companion object {
        const val ERR_NETWORK_BLOCKED = 1001
    }
}
