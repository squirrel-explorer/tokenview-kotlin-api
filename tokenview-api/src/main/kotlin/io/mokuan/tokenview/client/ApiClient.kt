/**
 * HTTP client
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

import io.mokuan.tokenview.client.config.ApiConfiguration
import io.mokuan.tokenview.client.exception.ApiNetworkException
import org.slf4j.LoggerFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.IOException

open class ApiClient(private val config: ApiConfiguration) {
    private val httpClient = ApiHttpClient(config)
    private val liteClient = ApiLiteClient(config, httpClient.client)

    // retrofit for synchronous calls
    private val retrofit = Retrofit.Builder()
        .client(httpClient.client)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(config.endpoint.url)
        .build()

    // retrofit for asynchronous calls
    private val retrofitAsync = Retrofit.Builder()
        .client(httpClient.client)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ApiResultCallAdapterFactory())
        .baseUrl(config.endpoint.url)
        .build()

    /**
     * Lite http methods - GET
     */
    fun httpGet(path: String, queryParams: Map<String, String>? = null): String {
        return liteClient.get(path, queryParams)
    }

    /**
     * Lite http methods - POST
     */
    fun httpPost(path: String, params: Map<String, String>, queryParams: Map<String, String>? = null): String {
        return liteClient.post(path, params, queryParams)
    }

    /**
     * Initialize the synchronous retrofit service
     */
    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }

    /**
     * Initialize the asynchronous retrofit service
     */
    fun <T> createAsyncService(service: Class<T>): T {
        return retrofitAsync.create(service)
    }

    /**
     * Execute the request synchronously
     */
    fun <T> executeSync(call: Call<out ResponseBean<T>>): T? {
        return try {
            val response = call.execute()

            val status = response.code()
            val body = response.body()

            if (response.isSuccessful && status in 200 until 300 &&
                body is ResponseBean<*> && body.code == "1") {
                when (body) {
                    is ResponseItemBean<*> -> {
                        body.data as T
                    }
                    is ResponseListBean<*> -> {
                        body.data[0] as T
                    }
                    else -> {
                        LOG.error("Unknown response data type: $body")
                        null
                    }
                }
            } else {
                LOG.error("Error response: ${response.message()}")
                null
            }
        } catch (e: IOException) {
            throw ApiNetworkException(ApiNetworkException.ERR_NETWORK_BLOCKED, "APIClient executeSync failed")
        }
    }

    /**
     * Execute the request asynchronously
     */
    fun <T> executeAsync(call: ApiResult<ResponseBean<T>>): T? {
        return when (call) {
            is ApiResult.Success<*> -> {
                when (call.data) {
                    is ResponseItemBean<*> -> {
                        call.data.data as T
                    }
                    is ResponseListBean<*> -> {
                        call.data.data[0] as T
                    }
                    else -> {
                        LOG.error("Unknown response data type: ${call.data}")
                        null
                    }
                }
            }
            is ApiResult.Failure -> {
                LOG.warn("errorCode: ${call.errorCode} errorMsg: ${call.errorMsg}")
                null
            }
        }
    }

    override fun toString(): String {
        return "ApiClient { config = $config, client = $httpClient, retrofit = $retrofitAsync }"
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(ApiClient::class.java)
    }
}