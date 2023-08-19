/**
 * Declaration of all blockchain -> general APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl.general

import io.mokuan.tokenview.api.bean.blockchain.general.BlockchainListBean
import io.mokuan.tokenview.api.SyncApi
import io.mokuan.tokenview.client.ResponseItemBean
import retrofit2.Call
import retrofit2.http.GET

interface BlockchainGeneralApi: SyncApi {
    @GET("/vipapi/block/latest/height")
    fun blockchainList(): Call<ResponseItemBean<BlockchainListBean>>
}