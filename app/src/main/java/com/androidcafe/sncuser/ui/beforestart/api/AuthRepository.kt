package com.androidcafe.sncuser.ui.beforestart.api


import com.androidcafe.sncuser.data.request.UserLoginRequestModel
import com.androidcafe.sncuser.data.response.UserResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepository @Inject constructor(val apiService: AuthApiService) {



    suspend fun loginUser(userLoginRequestModel: UserLoginRequestModel): Flow<UserResponseModel> = flow {
        val response = apiService.loginUser(userLoginRequestModel)
        emit(response)
    }

}