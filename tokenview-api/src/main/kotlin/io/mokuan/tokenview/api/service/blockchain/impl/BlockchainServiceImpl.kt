/**
 * Implementation for all blockchain APIs (combined)
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain.impl

import io.mokuan.tokenview.api.bean.blockchain.btc.BlockHeaderBean
import io.mokuan.tokenview.api.service.DefaultService
import io.mokuan.tokenview.api.service.blockchain.BlockchainService
import io.mokuan.tokenview.api.service.blockchain.impl.btc.BlockchainBTCServiceImpl
import io.mokuan.tokenview.api.service.blockchain.impl.general.BlockchainGeneralServiceImpl
import io.mokuan.tokenview.client.config.ApiConfiguration

class BlockchainServiceImpl(config: ApiConfiguration): DefaultService(config), BlockchainService {
    private val apiGeneral = BlockchainGeneralServiceImpl(client)
    private val apiBTC = BlockchainBTCServiceImpl(client)

    override fun getBlockchainList(): List<String> {
        return apiGeneral.getBlockchainList()
    }

    override suspend fun getBlockchainListAsync(): List<String> {
        return apiGeneral.getBlockchainListAsync()
    }

    override fun getBlockHeader(coin: String, blockHeight: Long): BlockHeaderBean {
        return apiBTC.getBlockHeader(coin, blockHeight)
    }

    override suspend fun getBlockHeaderAsync(coin: String, blockHeight: Long): BlockHeaderBean {
        return apiBTC.getBlockHeaderAsync(coin, blockHeight)
    }
}