package com.tma.training.sme.smeedaecom

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(
    exclude = [SecurityAutoConfiguration::class]
)
@EnableMongoRepositories(basePackageClasses = [SmeEdaEcomApplication::class])
@EnableConfigurationProperties
class SmeEdaEcomApplication

fun main(args: Array<String>) {
    runApplication<SmeEdaEcomApplication>(*args)
}
