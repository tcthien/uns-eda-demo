package com.tma.training.sme.smeedaecom.rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper
import com.tma.training.sme.smeedaecom.commons.dtos.AmsMessage
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.converter.AbstractMessageConverter
import org.springframework.messaging.converter.MessageConverter

@Configuration
class RabbitMQConsumerConfig {

    @Bean
    fun providesTextPlainMessageConverter(
        jacksonObjectMapper: ObjectMapper
    ): MessageConverter = object : AbstractMessageConverter() {
        override fun supports(clazz: Class<*>): Boolean = AmsMessage::class.java == clazz
        override fun convertFromInternal(message: Message<*>, targetClass: Class<*>, conversionHint: Any?): Any? {
            val payload = message.payload
            val json = if (payload is String) payload else String((payload as ByteArray))
            return jacksonObjectMapper.readValue(json, targetClass)
        }
    }

//    @Bean(EcomTopicConstants.ECOM__CONSUMER)
//    fun activityLogConsumer(recordActivityLog: RecordActivityLog): Consumer<AmsMessage> = Consumer<AmsMessage> {
//        log.debug(it.toString())
//        recordActivityLog.execute(it)
//    }

    @Bean
    fun rabbitMQEventBroadcaster(
        objectMapper: ObjectMapper,
        streamBridge: StreamBridge
    ): RabbitMQEventBroadcaster = object : RabbitMQEventBroadcaster(objectMapper, streamBridge) {}
}
