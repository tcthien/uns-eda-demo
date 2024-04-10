package com.tma.training.sme.smeedaconfig

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class SmeEdaConfigApplication

fun main(args: Array<String>) {
	runApplication<SmeEdaConfigApplication>(*args)
}
