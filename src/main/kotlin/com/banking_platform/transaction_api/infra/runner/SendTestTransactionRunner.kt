package com.banking_platform.transaction_api.infra.runner

import com.banking_platform.transaction_api.infra.kafka.TransactionProducer
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled

@Configuration
class SendTestTransactionRunner(
    private val producer: TransactionProducer,
) {

    private val logger = LoggerFactory.getLogger(SendTestTransactionRunner::class.java)
    @Bean
    @Scheduled(fixedDelay = 1_000)
    fun runOnStartup(): CommandLineRunner {
        return CommandLineRunner {
            logger.info("🔌 Iniciando teste de conexão com Kafka...")
            producer.sendTestMessage()
            logger.info("📨 Mensagem de teste enviada para transactions.raw")
        }
    }
}