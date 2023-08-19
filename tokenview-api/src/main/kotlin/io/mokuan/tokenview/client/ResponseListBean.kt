/**
 * Wrapper for resulting-bean (for list)
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

class ResponseListBean<T>(
    code: String,
    msg: String,
    val data: List<T>,
) : ResponseBean<T>(code, msg)
