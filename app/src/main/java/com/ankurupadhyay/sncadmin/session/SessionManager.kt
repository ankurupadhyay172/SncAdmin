package com.ankurupadhyay.sncadmin.session

import com.ankurupadhyay.sncadmin.data.response.UserResponseModel

interface SessionManager {

    fun saveUser(user: UserResponseModel.Result?)

    fun getUser():UserResponseModel.Result?


}