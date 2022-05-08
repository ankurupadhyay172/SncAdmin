package com.ankurupadhyay.sncadmin.ui.beforestart.api

import com.ankurupadhyay.sncadmin.data.request.UserLoginRequestModel
import com.ankurupadhyay.sncadmin.data.response.UserResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("loginstaff.php")
    suspend fun loginUser(@Body userLoginRequestModel: UserLoginRequestModel):UserResponseModel


}