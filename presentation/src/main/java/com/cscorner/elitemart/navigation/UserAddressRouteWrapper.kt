package com.cscorner.elitemart.navigation

import android.os.Parcelable
import com.cscorner.elitemart.model.UserAddress
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserAddressRouteWrapper(
    val userAddress: UserAddress?
) : Parcelable
