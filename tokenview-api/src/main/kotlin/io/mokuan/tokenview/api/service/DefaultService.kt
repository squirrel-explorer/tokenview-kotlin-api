/**
 * Base definition for all services
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service

import io.mokuan.tokenview.client.ApiClient
import io.mokuan.tokenview.client.config.ApiConfiguration

abstract class DefaultService(protected val config: ApiConfiguration) {
    protected val client = ApiClient(config)

    fun httpGet(path: String, queryParams: Map<String, String>? = null): String {
        return client.httpGet(path, queryParams)
    }

    fun httpPost(path: String, params: Map<String, String>, queryParams: Map<String, String>? = null): String {
        return client.httpPost(path, params, queryParams)
    }
}