package com.tma.training.sme.smeedaecom.rabbitmq

class EcomEventConstants {
    companion object {
        const val ECOM__CONSUMER = "ecomEventConsumer"
        const val ECOM__BROADCAST_TOPIC = "ecomStateTransfer-out-0"

        const val EVENT__SENDER = "ecom"
        const val EVENT__PRODUCT_CREATION = "productCreation"
        const val EVENT__PRODUCT_DELETE = "productDelete"

        const val EVENT__ORDER_CREATION = "orderCreation"
    }
}
