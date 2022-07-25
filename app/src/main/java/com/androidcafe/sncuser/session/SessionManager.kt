package com.androidcafe.sncuser.session

import com.androidcafe.sncuser.data.response.UserResponseModel

interface SessionManager {

    fun saveUser(user: UserResponseModel.Result?)

    fun getUser():UserResponseModel.Result?


}