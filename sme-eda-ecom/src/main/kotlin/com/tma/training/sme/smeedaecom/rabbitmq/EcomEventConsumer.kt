package com.tma.training.sme.smeedaecom.rabbitmq

import com.fasterxml.jackson.databind.ObjectMapper
import com.tma.training.sme.smeedaecom.commons.dtos.AmsMessage
import java.util.function.Consumer

class EcomEventConsumer(
    private val objectMapper: ObjectMapper,
) : Consumer<AmsMessage> {
    override fun accept(amsMessage: AmsMessage) {
        // Activity Log cannot be deleted so all events will be EntityUpdatedEvt
//        val event = objectMapper.readValue(amsMessage.body, EntityUpdatedEvt::class.java)
    }
}
