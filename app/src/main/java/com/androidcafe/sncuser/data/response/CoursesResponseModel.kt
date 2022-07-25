package com.androidcafe.sncuser.data.response

import com.google.gson.annotations.SerializedName

data class CoursesResponseModel (@SerializedName("status") val status : Int,
                                 @SerializedName("result") val result : List<Result>?)
{
    data class Result(
        @SerializedName("id") val id : String,
        @SerializedName("name") val name : String,
        @SerializedName("branch") val branch : String,
    )
}