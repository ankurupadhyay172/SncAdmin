package com.androidcafe.sncuser.data.response

import com.google.gson.annotations.SerializedName

data class StudentsResponseModel (@SerializedName("status") val status : Int,
                                  @SerializedName("result") val result : List<Result>?)
{
    data class Result(
        @SerializedName("student_id") val student_id : String,
        @SerializedName("user_id") val user_id : String,
        @SerializedName("password") val password : String,
        @SerializedName("student_name") val student_name : String,
        @SerializedName("branch") val branch : String,
        @SerializedName("student_course") val student_course : String,
        @SerializedName("student_year") val student_year : String,
    )
}