package com.banking_platform.transaction_api.infra.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class TransactionProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
) {
    fun sendTestMessage() {
        kafkaTemplate.send("transactions.raw", "teste-inicial")
    }
}