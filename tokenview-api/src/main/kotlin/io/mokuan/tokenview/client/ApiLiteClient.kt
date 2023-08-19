/**
 * Lite HTTP client for direct HTTP methods (Only for internal use)
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

import com.google.gson.Gson
import io.mokuan.tokenview.client.config.ApiConfiguration
import io.mokuan.tokenview.client.constant.ApiConstants
import io.mokuan.tokenview.client.constant.DatetimeFormat
import io.mokuan.tokenview.client.exception.ApiRuntimeException
import io.mokuan.tokenview.client.utils.DateUtils
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.slf4j.LoggerFactory
import java.io.IOException
import java.util.*

class ApiLiteClient(private val config: ApiConfiguration,
                    private val client: OkHttpClient) {
    fun get(path: String, queryParams: Map<String, String>? = null): String {
        val request = Request.Builder()
            .url(config.endpoint.url)
            .get()
            .build()
        val url = request.url.newBuilder()
            .addPathSegments(if (path.startsWith("/")) path.substring(1) else path)
            .apply { queryParams?.forEach { addQueryParameter(it.key, it.value) } }
            .build()
        return exec(request.newBuilder().url(url).build())
    }

    fun post(path: String, params: Map<String, String>, queryParams: Map<String, String>? = null): String {
        val body = FormBody.Builder()
            .apply { params.forEach { add(it.key, it.value) } }
            .build()
        val request = Request.Builder()
            .url(config.endpoint.url)
            .post(body)
            .build()
        val url = request.url.newBuilder()
            .addPathSegments(if (path.startsWith("/")) path.substring(1) else path)
            .apply { queryParams?.forEach { addQueryParameter(it.key, it.value) } }
            .build()
        return exec(request.newBuilder().url(url).build())
    }

    @Throws(IOException::class, ApiRuntimeException::class)
    private fun exec(request: Request): String {
        val response = client.newCall(request).execute()
        val status = response.code
        val bodyString = response.body?.string() ?: ""
        val message = "${response.code} / ${response.message}"

        if (config.logOutput) {
            printResponse(status, response.message, bodyString)
        }

        return if (response.isSuccessful) {
            bodyString
        } else if (ApiConstants.HANDLED_ERR_STATUS.contains(status)) {
            val result = Gson().fromJson(bodyString, HttpResponse::class.java)
            throw ApiRuntimeException(result.code, result.msg ?: "")
        } else {
            throw ApiRuntimeException(message)
        }
    }

    private fun printResponse(status: Int, message: String, body: String) {
        val responseInfo = StringBuilder()
        responseInfo.append("\n\tResponse").append("(").append(DateUtils.timeToString(Date(), DatetimeFormat.DATETIME_FORMAT_4)).append("):")
        responseInfo.append("\n\t\t").append("Status: ").append(status)
        responseInfo.append("\n\t\t").append("Message: ").append(message)
        responseInfo.append("\n\t\t").append("Response Body: ").append(body)
        LOG.info(responseInfo.toString())
    }

    companion object {
        private val LOG = LoggerFactory.getLogger(ApiLiteClient::class.java)
    }
}