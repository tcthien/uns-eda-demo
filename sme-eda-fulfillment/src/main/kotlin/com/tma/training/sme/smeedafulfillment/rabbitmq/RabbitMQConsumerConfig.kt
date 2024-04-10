package com.tma.training.sme.smeedafulfillment.rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper
import com.tma.training.sme.smeedafulfillment.apis.orders.dtos.OrderCreatedEvt
import com.tma.training.sme.smeedafulfillment.apis.products.dtos.ProductCreatedEvt
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.orders.CreateOrderFromEvent
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.productstatistic.RecordProductStatistic
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.CreateTagFromEvent
import com.tma.training.sme.smeedafulfillment.businesses.boundaries.tags.DeleteTag
import com.tma.training.sme.smeedafulfillment.commons.dtos.AmsMessage
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.converter.AbstractMessageConverter
import org.springframework.messaging.converter.MessageConverter
import java.util.function.Consumer

@Configuration
class RabbitMQConsumerConfig(
    private val objectMapper: ObjectMapper,
    private val createTagFromEvent: CreateTagFromEvent,
    private val deleteTag: DeleteTag,
    private val recordProductStatistic: RecordProductStatistic,
    private val createOrderFromEvent: CreateOrderFromEvent,
){

    companion object {
        private val LOGGER = LoggerFactory.getLogger(RabbitMQConsumerConfig::class.java)
    }

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

    @Bean(FulfillmentEventConstants.ECOM__CONSUMER)
    fun fulfillmentConsumer(): Consumer<AmsMessage> = Consumer<AmsMessage> {amsMessage ->
        LOGGER.debug("HANDLE EVENT: {}. {}", amsMessage.type, amsMessage)
        when (amsMessage.type) {
            FulfillmentEventConstants.EVENT__ECOM__PRODUCT_CREATION -> {
                val event = objectMapper.readValue(amsMessage.body, ProductCreatedEvt::class.java)
                createTagFromEvent.execute(event)
                recordProductStatistic.execute(RecordProductStatistic.Request(1))
            }
            FulfillmentEventConstants.EVENT__ECOM__PRODUCT_DELETE -> {
                val event = objectMapper.readValue(amsMessage.body, ProductCreatedEvt::class.java)
                deleteTag.execute(DeleteTag.Request(event.id!!))
                recordProductStatistic.execute(RecordProductStatistic.Request(-1))
            }

            FulfillmentEventConstants.EVENT__ECOM__ORDER_CREATION -> {
                val event = objectMapper.readValue(amsMessage.body, OrderCreatedEvt::class.java)
                createOrderFromEvent.execute(event)
            }

            else -> {}
        }
    }

    @Bean
    fun rabbitMQEventBroadcaster(
        objectMapper: ObjectMapper,
        streamBridge: StreamBridge,
    ): RabbitMQEventBroadcaster =
        object : RabbitMQEventBroadcaster(objectMapper, streamBridge){}
}
