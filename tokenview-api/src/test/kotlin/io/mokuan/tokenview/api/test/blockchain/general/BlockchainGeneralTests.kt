package io.mokuan.tokenview.api.test.blockchain.general

import io.mokuan.tokenview.api.test.ApiTests
import io.mokuan.tokenview.api.test.blockchain.BlockchainTests
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BlockchainGeneralTests: ApiTests() {
    @BeforeEach
    override fun beforeTest() {
        super.beforeTest()
    }

    @AfterEach
    override fun afterTest() {
        super.afterTest()
    }

    @Test
    fun testBlockchainList() {
        val blockchainList = BlockchainTests.service.getBlockchainList()
        assertEquals(blockchainList.size, 121)
    }
}