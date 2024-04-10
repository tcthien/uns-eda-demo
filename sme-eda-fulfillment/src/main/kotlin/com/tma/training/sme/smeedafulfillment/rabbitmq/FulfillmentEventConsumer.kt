package com.tma.training.sme.smeedafulfillment.rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper
import com.tma.training.sme.smeedafulfillment.commons.dtos.AmsMessage
import java.util.function.Consumer

class FulfillmentEventConsumer(
    private val objectMapper: ObjectMapper,
) : Consumer<AmsMessage> {
    override fun accept(amsMessage: AmsMessage) {
        // Activity Log cannot be deleted so all events will be EntityUpdatedEvt
    }
}
