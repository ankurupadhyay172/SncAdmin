package com.androidcafe.sncuser.data.response

import com.google.gson.annotations.SerializedName

data class UserResponseModel (@SerializedName("status") val status : Int,
                              @SerializedName("result") val result : List<Result>) {


    data class Result (

        @SerializedName("staff_id") val id : String,
        @SerializedName("user_name") val name : String,
        @SerializedName("user_id") val user_id : String,
        @SerializedName("password") val password : String,
        @SerializedName("staff_type") val staff_type : String,
        @SerializedName("staff_branch")val staff_branch:String
    )
}