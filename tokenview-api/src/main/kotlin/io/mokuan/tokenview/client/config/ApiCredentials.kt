/**
 * User credentials for API request
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.config

open class ApiCredentials() {
    // The user's API key
    var apiKey: String = ""
        get() = field.ifBlank { System.getenv("TOKENVIEW_API_KEY") ?: "" }

    // The user's secret key
    var secretKey: String? = null

    // The user's passphrase
    var passphrase: String? = null

    constructor(apiKey: String, secretKey: String? = null, passphrase: String? = null) : this() {
        this.apiKey = apiKey
        this.secretKey = secretKey
        this.passphrase = passphrase
    }
}