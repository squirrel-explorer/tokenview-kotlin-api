package io.mokuan.tokenview.api.test.blockchain.btc

import io.mokuan.tokenview.api.test.ApiTests
import io.mokuan.tokenview.api.test.blockchain.BlockchainTests
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BlockchainBTCTests: ApiTests() {
    @BeforeEach
    override fun beforeTest() {
        super.beforeTest()
    }

    @AfterEach
    override fun afterTest() {
        super.afterTest()
    }

    @ParameterizedTest
    @CsvSource("btc, 1")
    fun testBlockHeader(coin: String, blockHeight: Long) {
        val blockHeader = BlockchainTests.service.getBlockHeader(coin, blockHeight)
        assertEquals(blockHeader.blockHash, "00000000839a8e6886ab5951d76f411475428afc90947ee320161bbf18eb6048")
        assertEquals(blockHeader.prevBlockHash, "000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f")
        assertEquals(blockHeader.nextBlockHash, "000000006a625f06636b8bb6ac7b960a8d03705d1ace08b1a19da3fdcc99ddbd")
    }
}