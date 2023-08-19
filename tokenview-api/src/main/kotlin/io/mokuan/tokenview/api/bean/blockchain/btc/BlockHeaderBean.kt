/**
 * Bean for BlockHeaderInfo
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.bean.blockchain.btc

import com.google.gson.annotations.SerializedName

data class BlockHeaderBean(
    val type: String = "",
    val network: String = "",
    @SerializedName(value = "blockNo", alternate = ["block_no"])
    val blockNo: Long = -1,
    @SerializedName(value = "blockTime", alternate = ["time"])
    val blockTime: Long = -1,
    @SerializedName(value = "blockSize", alternate = ["size"])
    val blockSize: Int = -1,
    @SerializedName(value = "blockHash", alternate = ["blockhash"])
    val blockHash: String = "",
    @SerializedName(value = "prevBlockHash", alternate = ["previous_blockhash"])
    val prevBlockHash: String = "",
    @SerializedName(value = "nextBlockHash", alternate = ["next_blockhash"])
    val nextBlockHash: String = "",
    val fee: String = "",
    val reward: String = "",
    val confirmations: Int = -1,
    val miner: String = "",
    val minerAlias: String = "",
    @SerializedName(value = "miningDifficulty", alternate = ["mining_difficulty"])
    val miningDifficulty: String = "",
    @SerializedName(value = "merkleRoot", alternate = ["merkleroot"])
    val merkleRoot: String = "",
    @SerializedName(value = "sentValue", alternate = ["sent_value"])
    val sentValue: String = "",
    val txCnt: Int = -1,
    val txs: List<BlockTransactionBean> = arrayListOf(),
)