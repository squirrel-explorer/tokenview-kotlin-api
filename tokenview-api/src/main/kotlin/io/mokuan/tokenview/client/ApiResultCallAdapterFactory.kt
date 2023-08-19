/**
 * Retrofit CallAdapter for API validation and exception-handling
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.client

import io.mokuan.tokenview.client.exception.ApiNetworkException
import retrofit2.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ApiResultCallAdapterFactory : CallAdapter.Factory() {
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *> {
        // Validate return type
        check(getRawType(returnType) == Call::class.java) { "$returnType must be retrofit2.Call" }
        check(returnType is ParameterizedType) { "$returnType must be parameterized" }

        // Validate ApiResult<T> in return-type Call<ApiResult<T>>
        val resultType = getParameterUpperBound(0, returnType)
        check(getRawType(resultType) == ApiResult::class.java) { "$resultType must be ApiResult" }
        check(resultType is ParameterizedType) { "$resultType must be parameterized" }

        // Use T in ApiResult<T>
        val dataType = getParameterUpperBound(0, resultType)
        return ApiResultCallAdapter<Any>(dataType)
    }
}

class ApiResultCallAdapter<T>(private val type: Type) : CallAdapter<T, Call<ApiResult<T>>> {
    override fun responseType() = type

    override fun adapt(call: Call<T>) = ApiResultCall(call)
}

class ApiResultCall<T>(private val delegate: Call<T>) : Call<ApiResult<T>> {
    override fun enqueue(callback: Callback<ApiResult<T>>) {
        delegate.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {    // 200
                    val apiResult = if (response.body() == null) {
                        ApiResult.Failure(ApiError.bodyIsNull.errorCode, ApiError.bodyIsNull.errorMsg)
                    } else {
                        ApiResult.Success(response.body()!!)
                    }
                    callback.onResponse(this@ApiResultCall, Response.success(apiResult))
                } else {    // May other error status
                    val failureApiResult =
                        ApiResult.Failure(ApiError.httpStatusCodeError.errorCode, ApiError.httpStatusCodeError.errorMsg)
                    callback.onResponse(this@ApiResultCall, Response.success(failureApiResult))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val failureApiResult = when (t) {
                    is ApiNetworkException -> ApiResult.Failure(t.errCode, t.errMsg)
                    else -> ApiResult.Failure(ApiError.unknownException.errorCode, ApiError.unknownException.errorMsg)
                }

                callback.onResponse(this@ApiResultCall, Response.success(failureApiResult))
            }
        })
    }

    override fun clone() = ApiResultCall(delegate.clone())

    override fun execute(): Response<ApiResult<T>> = throw UnsupportedOperationException("Synchronized-execution is NOT allowed")

    override fun isExecuted() = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled() = delegate.isCanceled

    override fun request() = delegate.request()

    override fun timeout() = delegate.timeout()
}
