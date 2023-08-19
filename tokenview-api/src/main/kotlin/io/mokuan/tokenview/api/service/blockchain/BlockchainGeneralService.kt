/**
 * Interface for all blockchain -> general APIs
 *
 * @copyright       Copyright 2022 - 2023, mokuan.io
 * @license         MIT
 */

package io.mokuan.tokenview.api.service.blockchain

import io.mokuan.tokenview.api.ApiService

interface BlockchainGeneralService: ApiService {
    fun getBlockchainList(): List<String>
    suspend fun getBlockchainListAsync(): List<String>
}