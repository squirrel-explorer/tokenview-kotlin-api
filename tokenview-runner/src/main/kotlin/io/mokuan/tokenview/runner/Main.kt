package io.mokuan.tokenview.runner

import io.mokuan.tokenview.api.service.blockchain.impl.BlockchainServiceImpl
import io.mokuan.tokenview.client.config.ApiConfiguration
import io.mokuan.tokenview.client.config.ApiCredentials
import io.mokuan.tokenview.client.config.ApiEndpoint
import kotlinx.coroutines.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val endpoint = ApiEndpoint()
        val credentials = ApiCredentials()
        val config = ApiConfiguration(endpoint, credentials)
        val service = BlockchainServiceImpl(config)
        val blockHeader = runBlocking {
            service.getBlockHeaderAsync("btc", 1)
        }
        println("EXAMPLE: network = ${blockHeader.network}, block_no = ${blockHeader.blockNo}, blockhash = ${blockHeader.blockHash}")
    }
}
