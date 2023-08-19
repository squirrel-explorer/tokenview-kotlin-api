/**
 * Bean for BlockTransaction
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.bean.blockchain.btc

class BlockTransactionBean(
    val type: String,
    val network: String,
    val block_no: Long,
    val height: Long,
    val index: Int,
    val time: Long,
    val txid: String,
    val fee: String,
    val confirmations: Int,
    val inputCnt: Int,
    val inputs: List<UTXOInputBean>,
    val outputCnt: Int,
    val outputs: List<UTXOOutputBean>,
)