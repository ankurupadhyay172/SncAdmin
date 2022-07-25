package com.androidcafe.sncuser.data.response

import com.google.gson.annotations.SerializedName

data class CommonResponseModel (@SerializedName("status") val status : Int,
                                @SerializedName("result") val result : String?)