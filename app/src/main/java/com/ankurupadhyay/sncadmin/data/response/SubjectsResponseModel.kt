package com.ankurupadhyay.sncadmin.data.response

import com.google.gson.annotations.SerializedName

data class SubjectsResponseModel (@SerializedName("status") val status : Int,
                                  @SerializedName("result") val result : List<Result>?)
{
    data class Result(
        @SerializedName("sub_id") val sub_id : String,
        @SerializedName("sub_name") val sub_name : String,
        @SerializedName("course_id") val course_id : String,
        @SerializedName("course_branch") val course_branch : String,
    )
}