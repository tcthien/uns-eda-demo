package com.tma.training.sme.smeedaecom.businesses.services

import kotlin.random.Random

class OrderNumberGenerator {

    companion object {
        private val charPoolUpperCase: List<Char> = ('A'..'Z') + ('0'..'9')


        /**
         * input: retryCounter should < 10
         * output: an unique order number = currentDateString + randomCharacter + uniqueSuffix
         * */
        @JvmStatic
        fun generateOrderNumber(): String = randomizeUpperCaseAlphaNumeric(12)

        @JvmStatic
        fun randomizeUpperCaseAlphaNumeric(generateLength: Int, prefix: String = ""): String {
            return (1..generateLength)
                .map { _ -> Random.nextInt(0, charPoolUpperCase.size) }
                .map(charPoolUpperCase::get)
                .joinToString("").let {
                    "$prefix$it".replace("-", "")
                }
        }
    }
}
