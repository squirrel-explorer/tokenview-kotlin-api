package io.mokuan.tokenview.api.test.blockchain.general

import io.mokuan.tokenview.api.test.ApiTests
import io.mokuan.tokenview.api.test.blockchain.BlockchainTests
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BlockchainGeneralAsyncTests: ApiTests() {
    @BeforeEach
    override fun beforeTest() {
        super.beforeTest()
    }

    @AfterEach
    override fun afterTest() {
        super.afterTest()
    }

    @Test
    fun testBlockchainListAsync() {
        runBlocking {
            val blockchainList = BlockchainTests.service.getBlockchainListAsync()
            assertEquals(blockchainList.size, 121)
        }
    }
}