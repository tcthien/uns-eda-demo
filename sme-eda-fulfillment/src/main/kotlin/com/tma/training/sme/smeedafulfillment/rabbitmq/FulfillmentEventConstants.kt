package com.tma.training.sme.smeedafulfillment.rabbitmq

class FulfillmentEventConstants {
    companion object {
        const val FULFILLMENT__CONSUMER = "fulfillmentEventConsumer"
        const val FULFILLMENT__BROADCAST_TOPIC = "$FULFILLMENT__CONSUMER-out-0"

        const val ECOM__CONSUMER = "ecomEventConsumer"

        const val EVENT__SENDER = "fulfillment"


        const val EVENT__ECOM__PRODUCT_CREATION = "productCreation"
        const val EVENT__ECOM__PRODUCT_DELETE = "productDelete"
        const val EVENT__ECOM__ORDER_CREATION = "orderCreation"
    }
}
