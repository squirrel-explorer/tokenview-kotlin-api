/**
 * Base HTTP client (DO NOT USE DIRECTLY)
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

import io.mokuan.tokenview.client.config.ApiConfiguration
import io.mokuan.tokenview.client.constant.ApiConstants
import io.mokuan.tokenview.client.constant.Charset
import io.mokuan.tokenview.client.constant.ContentType
import io.mokuan.tokenview.client.exception.ApiRuntimeException
import io.mokuan.tokenview.client.exception.ApiIllegalArgumentsException
import io.mokuan.tokenview.client.utils.DateUtils
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.Buffer
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

open class ApiHttpClient(val config: ApiConfiguration) {
    val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .connectTimeout(config.connectTimeout, TimeUnit.SECONDS)
            .readTimeout(config.readTimeout, TimeUnit.SECONDS)
            .writeTimeout(config.writeTimeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(config.retryOnConnectionFailure)
            .addInterceptor { chain: Interceptor.Chain ->
                val timestamp = DateUtils.simpleTime
                val originalRequest = chain.request()
                val url = originalRequest.url.newBuilder()
                    .addQueryParameter("apikey", config.apiKey)
                    .build()
                val request = originalRequest.newBuilder()
                    .headers(generateHeaders(originalRequest, timestamp))
                    .url(url)
                    .build()

                if (config.logOutput) {
                    logRequest(request, timestamp)
                }

                chain.proceed(request)
            }
            .build()

    fun generateHeaders(request: Request, timestamp: String): Headers {
        if (StringUtils.isEmpty(config.apiKey)) {
            throw ApiIllegalArgumentsException("apiKey CANNOT be NULL")
        }
//        if (StringUtils.isEmpty(config.secretKey)) {
//            throw ApiIllegalArgumentsException("secretKey CANNOT be NULL")
//        }
//        if (StringUtils.isEmpty(config.passphrase)) {
//            throw ApiIllegalArgumentsException("passphrase CANNOT be NULL")
//        }

        return Headers.Builder()
            .add(ApiConstants.ACCEPT, ContentType.APPLICATION_JSON.type)
            .add(ApiConstants.CONTENT_TYPE, ContentType.APPLICATION_JSON.type)
            .build()
    }

    @Throws(IOException::class)
    private fun requestBody(request: Request): String {
        val buffer = Buffer()
        request.body?.writeTo(buffer)
        return buffer.readString(Charset.UTF_8.instance)
    }

    private fun logRequest(request: Request, timestamp: String) {
        val url = request.url.toString()
        val method = request.method.uppercase()
        val requestPath = request.url.toUri().path
        val body = try {
            requestBody(request)
        } catch (e: IOException) {
            throw ApiRuntimeException("Failed to retrieve request body.")
        }

        val requestInfo = StringBuilder()
            .append("\nRequest at $timestamp: ")
            .append("\n\tUrl: $url")
            .append("\n\tMethod: $method")
            .append("\n\tPath: $requestPath")
            .append("\n\tBody: $body")
            .apply {
                if (request.headers.size > 0) {
                    append("\n\tHeaders: ")
                    for ((k, v) in request.headers) {
                        append("\n\t\t$k: $v")
                    }
                }
            }
            .append("\n")

        LOG.info(requestInfo.toString())
    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ApiHttpClient::class.java)
    }
}