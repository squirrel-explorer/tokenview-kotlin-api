package io.mokuan.tokenview.api.test

import io.mokuan.tokenview.client.config.ApiConfiguration
import io.mokuan.tokenview.client.config.ApiCredentials
import io.mokuan.tokenview.client.config.ApiEndpoint
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class ApiTests {
    companion object {
        val endpoint = ApiEndpoint()
        val credentials = ApiCredentials()
        val config = ApiConfiguration(endpoint, credentials)
    }

    @BeforeEach
    open fun beforeTest() {
    }

    @AfterEach
    open fun afterTest() {
    }
}