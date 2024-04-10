package com.tma.training.sme.smeedafulfillment.commons.dtos

data class AmsMessage(
    var type: String = "",
    var version: Int = 1,
    var source: String = "",
    var target: String = "",
    var bodyClass: String = "",
    var body: String = ""
) {
    fun headerAttributes(): Map<String, Any> {
        val rs = mutableMapOf<String, Any>()
        if (type.isNotBlank()) {
            rs["type"] = type.trim()
        }
        rs["version"] = version
        if (source.isNotBlank()) {
            rs["source"] = source.trim()
        }
        if (target.isNotBlank()) {
            rs["target"] = target.trim()
        }
        if (bodyClass.isNotBlank()) {
            rs["bodyClass"] = bodyClass.trim()
        }
        return rs
    }
}