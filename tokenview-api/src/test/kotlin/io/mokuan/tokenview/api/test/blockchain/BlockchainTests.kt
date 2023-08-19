package io.mokuan.tokenview.api.test.blockchain

import io.mokuan.tokenview.api.service.blockchain.impl.BlockchainServiceImpl
import io.mokuan.tokenview.api.test.ApiTests
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

class BlockchainTests: ApiTests() {
    companion object {
        val service = BlockchainServiceImpl(config)
    }

    @BeforeEach
    override fun beforeTest() {
        super.beforeTest()
    }

    @AfterEach
    override fun afterTest() {
        super.afterTest()
    }
}