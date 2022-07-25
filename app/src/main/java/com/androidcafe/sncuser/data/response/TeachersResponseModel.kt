package com.androidcafe.sncuser.data.response

import com.google.gson.annotations.SerializedName

data class TeachersResponseModel (@SerializedName("status") val status : Int,
                                  @SerializedName("result") val result : List<Result>?)
{
    data class Result(
        @SerializedName("teacher_id") val student_id : String,
        @SerializedName("user_id") val user_id : String,
        @SerializedName("password") val password : String,
        @SerializedName("teacher_name") val teacher_name : String,
        @SerializedName("teacher_branch") val teacher_branch : String,
        @SerializedName("teacher_course") val teacher_course : String,
        @SerializedName("teacher_subjects") val teacher_subjects : String,

    )
}