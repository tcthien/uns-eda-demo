package com.tma.training.sme.smeedaecom.apis.customers.dtos

data class CustomerRequestDto(
    var userName: String = "",
    var email: String = "",

    var firstName: String = "",
    var middleName: String = "",
    var lastName: String = "",
    var phone: String = "",
)