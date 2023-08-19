/**
 * Constant definitions for Charset
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.constant

enum class Charset(val charsetName: String) {
    UTF_8("UTF-8"),
    ;

    val instance: java.nio.charset.Charset = java.nio.charset.Charset.forName(charsetName)
}