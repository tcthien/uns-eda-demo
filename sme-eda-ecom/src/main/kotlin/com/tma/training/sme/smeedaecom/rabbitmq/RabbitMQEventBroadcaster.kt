package com.tma.training.sme.smeedaecom.rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper
import com.tma.training.sme.smeedaecom.commons.dtos.AmsMessage
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import kotlin.reflect.jvm.jvmName

abstract class RabbitMQEventBroadcaster(
    private val objectMapper: ObjectMapper,
    private val streamBridge: StreamBridge,
) {
    protected fun convertToAmsMessage(event: Any): AmsMessage = AmsMessage().apply {
        bodyClass = event::class.jvmName
        body = objectMapper.writeValueAsString(event)
    }

    fun send(event: Any, eventType: String) {
        val amsMessage = convertToAmsMessage(event)
        amsMessage.type = eventType
        amsMessage.source = EcomEventConstants.EVENT__SENDER
        streamBridge.send(
            EcomEventConstants.ECOM__BROADCAST_TOPIC,
            MessageBuilder.createMessage(
                amsMessage,
                MessageHeaders(amsMessage.headerAttributes())
            )
        )
    }
}
