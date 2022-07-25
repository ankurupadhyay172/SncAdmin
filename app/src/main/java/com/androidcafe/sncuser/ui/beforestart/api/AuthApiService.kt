package com.androidcafe.sncuser.ui.beforestart.api

import com.androidcafe.sncuser.data.request.UserLoginRequestModel
import com.androidcafe.sncuser.data.response.UserResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("loginstaff.php")
    suspend fun loginUser(@Body userLoginRequestModel: UserLoginRequestModel):UserResponseModel


}