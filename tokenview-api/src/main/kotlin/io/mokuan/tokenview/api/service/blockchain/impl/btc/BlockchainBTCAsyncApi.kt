/**
 * Declaration of all blockchain -> btc-category APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl.btc

import io.mokuan.tokenview.api.bean.blockchain.btc.BlockHeaderBean
import io.mokuan.tokenview.api.AsyncApi
import io.mokuan.tokenview.client.ApiResult
import io.mokuan.tokenview.client.ResponseListBean
import retrofit2.http.GET
import retrofit2.http.Path

interface BlockchainBTCAsyncApi: AsyncApi {
    @GET("vipapi/block/{coin}/{blockHeight}")
    suspend fun getBlockHeaderAsync(@Path("coin") coin: String, @Path("blockHeight") blockHeight: Int): ApiResult<ResponseListBean<BlockHeaderBean>>
}