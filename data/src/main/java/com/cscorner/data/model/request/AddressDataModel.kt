package com.cscorner.data.model.request

import com.cscorner.domain.model.AddressDomainModel
import kotlinx.serialization.Serializable

@Serializable
data class AddressDataModel(
    val addressLine: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
)
{
    companion object{
        fun fromDomainAddress(userAddress: AddressDomainModel){
            AddressDataModel(
                userAddress.addressLine,
                userAddress.city,
                userAddress.state,
                userAddress.postalCode,
                userAddress.country
            )
        }
    }
}