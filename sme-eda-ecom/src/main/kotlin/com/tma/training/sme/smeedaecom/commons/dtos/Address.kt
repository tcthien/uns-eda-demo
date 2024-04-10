package com.tma.training.sme.smeedaecom.commons.dtos

data class Address(
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var company: String? = null,

    var street: String? = null,
    var addressLine2: String? = null,
    var country: String? = null,
    var countryName: String? = null,
    var stateOrProvince: String? = null,
    var stateName: String? = null,
    var city: String? = null,
    var postCode: String? = null,

    var type: AddressType = AddressType.NONE
)
