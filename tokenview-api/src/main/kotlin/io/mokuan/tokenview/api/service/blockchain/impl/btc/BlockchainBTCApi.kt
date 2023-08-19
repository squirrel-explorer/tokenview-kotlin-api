/**
 * Declaration of all blockchain -> btc-category APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl.btc

import io.mokuan.tokenview.api.bean.blockchain.btc.BlockHeaderBean
import io.mokuan.tokenview.api.SyncApi
import io.mokuan.tokenview.client.ResponseListBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlockchainBTCApi: SyncApi {
    @GET("vipapi/block/{coin}/{blockHeight}")
    fun getBlockHeader(@Path("coin") coin: String, @Path("blockHeight") blockHeight: Int): Call<ResponseListBean<BlockHeaderBean>>
}