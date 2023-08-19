/**
 * API endpoint url
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client.config

open class ApiEndpoint (var url: String = "https://services.tokenview.io",  // The api endpoint url from OKX
                        var isSimulated: Boolean = false,       // Whether the api endpoint is in test/simulation environment
)
