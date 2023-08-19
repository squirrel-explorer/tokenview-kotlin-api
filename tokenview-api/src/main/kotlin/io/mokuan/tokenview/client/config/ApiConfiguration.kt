/**
 * Configuration for API request
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.config

import io.mokuan.tokenview.client.constant.ApiConstants
import io.mokuan.tokenview.client.constant.I18nEnum

open class ApiConfiguration (val endpoint: ApiEndpoint,  // The API endpoint url
                             private val credentials: ApiCredentials,    // The credentials of the user
) {
    val apiKey: String
        get() = this.credentials.apiKey

    val secretKey: String?
        get() = this.credentials.secretKey

    val passphrase: String?
        get() = this.credentials.passphrase

    // The host connection-timeout
    var connectTimeout = ApiConstants.TIMEOUT

    // The host reading-timeout
    var readTimeout = ApiConstants.TIMEOUT

    // The host writing-timeout
    var writeTimeout = ApiConstants.TIMEOUT

    // Whether to reconnect when failure
    var retryOnConnectionFailure = true

    // The internationalization setting
    var i18n = I18nEnum.ENGLISH

    // Whether to output logs
    var logOutput = true
}