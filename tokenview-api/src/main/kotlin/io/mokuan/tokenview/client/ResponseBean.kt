/**
 * Wrapper for resulting-bean
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

abstract class ResponseBean<T>(
    val code: String,
    val msg: String,
)
