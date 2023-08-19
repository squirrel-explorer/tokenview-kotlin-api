/**
 * Common constant definitions
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.constant

object ApiConstants {
    /**
     * Default timeout
     */
    const val TIMEOUT = 30 * 1000L

    /**
     * HTTP Request
     */
    const val ACCEPT = "Accept"
    const val CONTENT_TYPE = "Content-Type"
    val HANDLED_ERR_STATUS = hashSetOf(
        400, 401, 429, 500
    )
}