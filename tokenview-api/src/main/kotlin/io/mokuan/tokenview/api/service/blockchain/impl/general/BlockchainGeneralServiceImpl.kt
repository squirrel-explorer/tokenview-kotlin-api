/**
 * Implementation for all blockchain -> general APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl.general

import io.mokuan.tokenview.api.bean.blockchain.general.BlockchainListBean
import io.mokuan.tokenview.api.service.blockchain.BlockchainGeneralService
import io.mokuan.tokenview.client.ApiClient

class BlockchainGeneralServiceImpl(private val client: ApiClient): BlockchainGeneralService {
    private val api = client.createService(BlockchainGeneralApi::class.java)
    private val apiAsync = client.createAsyncService(BlockchainGeneralAsyncApi::class.java)

    override fun getBlockchainList(): List<String> {
        return (client.executeSync(api.blockchainList()) ?: BlockchainListBean()).keys.map { it.lowercase() }.toSortedSet().toList()
    }

    override suspend fun getBlockchainListAsync(): List<String> {
        return (client.executeAsync(apiAsync.blockchainListAsync()) ?: BlockchainListBean()).keys.map { it.lowercase() }.toSortedSet().toList()
    }
}