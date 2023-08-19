/**
 * Interface for all blockchain -> btc-category APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain

import io.mokuan.tokenview.api.bean.blockchain.btc.BlockHeaderBean
import io.mokuan.tokenview.api.ApiService

interface BlockchainBTCService: ApiService {
    fun getBlockHeader(coin: String, blockHeight: Int): BlockHeaderBean
    suspend fun getBlockHeaderAsync(coin: String, blockHeight: Int): BlockHeaderBean
}