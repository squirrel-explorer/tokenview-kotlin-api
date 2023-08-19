/**
 * Implementation for all blockchain -> btc-category APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl.btc

import io.mokuan.tokenview.api.bean.blockchain.btc.BlockHeaderBean
import io.mokuan.tokenview.api.service.blockchain.BlockchainBTCService
import io.mokuan.tokenview.client.ApiClient

class BlockchainBTCServiceImpl(private val client: ApiClient): BlockchainBTCService {
    private val api = client.createService(BlockchainBTCApi::class.java)
    private val apiAsync = client.createAsyncService(BlockchainBTCAsyncApi::class.java)

    override fun getBlockHeader(coin: String, blockHeight: Long): BlockHeaderBean {
        return client.executeSync(api.getBlockHeader(coin, blockHeight)) ?: BlockHeaderBean()
    }

    override suspend fun getBlockHeaderAsync(coin: String, blockHeight: Long): BlockHeaderBean {
        return client.executeAsync(apiAsync.getBlockHeaderAsync(coin, blockHeight)) ?: BlockHeaderBean()
    }
}