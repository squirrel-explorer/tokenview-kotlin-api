/**
 * Bean for UTXO output
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.bean.blockchain.btc

class UTXOOutputBean(
    val output_no: String,
    val address: String,
    val addressAlias: String,
    val value: String,
    val asm: String,
    val hex: String,
    val signature: String,
    val received_from: HashMap<String, Any>,
)