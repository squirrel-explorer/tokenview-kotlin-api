/**
 * Declaration of all blockchain -> general APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl.general

import io.mokuan.tokenview.api.bean.blockchain.general.BlockchainListBean
import io.mokuan.tokenview.api.AsyncApi
import io.mokuan.tokenview.client.ApiResult
import io.mokuan.tokenview.client.ResponseItemBean
import retrofit2.http.GET

interface BlockchainGeneralAsyncApi: AsyncApi {
    @GET("/vipapi/block/latest/height")
    suspend fun blockchainListAsync(): ApiResult<ResponseItemBean<BlockchainListBean>>
}