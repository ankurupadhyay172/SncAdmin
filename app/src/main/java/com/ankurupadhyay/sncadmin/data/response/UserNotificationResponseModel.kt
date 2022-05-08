package com.ankurupadhyay.sncadmin.data.response

import com.google.gson.annotations.SerializedName

data class UserNotificationResponseModel (@SerializedName("status") val status : Int,
                                          @SerializedName("result") val result : List<Result>) {


    data class Result (

        @SerializedName("id") val id : String,
        @SerializedName("title") val title : String,
        @SerializedName("body") val body : String,
        @SerializedName("document") val document : String,
        @SerializedName("send_from") val send_from : String,
        @SerializedName("send_to") val send_to : String,
        @SerializedName("selected_branch") val selected_branch : String,
        @SerializedName("send_timestamp") val send_timestamp : String
    )
}