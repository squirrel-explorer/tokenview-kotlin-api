/**
 * Wrapper for resulting-bean (for single item)
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

class ResponseItemBean<T>(
    code: String,
    msg: String,
    val data: T,
) : ResponseBean<T>(code, msg)
