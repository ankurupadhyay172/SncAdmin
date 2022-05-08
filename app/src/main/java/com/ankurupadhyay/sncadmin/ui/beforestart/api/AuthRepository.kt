package com.ankurupadhyay.sncadmin.ui.beforestart.api


import com.ankurupadhyay.sncadmin.data.request.UserLoginRequestModel
import com.ankurupadhyay.sncadmin.data.response.UserResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepository @Inject constructor(val apiService: AuthApiService) {



    suspend fun loginUser(userLoginRequestModel: UserLoginRequestModel): Flow<UserResponseModel> = flow {
        val response = apiService.loginUser(userLoginRequestModel)
        emit(response)
    }

}