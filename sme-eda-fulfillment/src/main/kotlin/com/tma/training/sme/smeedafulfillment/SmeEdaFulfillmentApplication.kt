package com.tma.training.sme.smeedafulfillment

import com.tma.training.sme.smeedaecom.restclient.EcomRestClientConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(
    exclude = [SecurityAutoConfiguration::class]
)
@EnableMongoRepositories(basePackageClasses = [SmeEdaFulfillmentApplication::class])
@EnableConfigurationProperties
@Import(EcomRestClientConfig::class)
class SmeEdaFulfillmentApplication

fun main(args: Array<String>) {
    runApplication<SmeEdaFulfillmentApplication>(*args)
}
