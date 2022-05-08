package com.ankurupadhyay.sncadmin.ui.home.api


import com.ankurupadhyay.sncadmin.data.request.CommonRequestModel
import com.ankurupadhyay.sncadmin.data.request.CourseRequestModel
import com.ankurupadhyay.sncadmin.data.request.SendNotificationRequestModel
import com.ankurupadhyay.sncadmin.data.request.UserLoginRequestModel
import com.ankurupadhyay.sncadmin.data.response.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(val apiService: HomeApiService) {



    suspend fun readNotifications(): Flow<UserNotificationResponseModel> = flow {
        val response = apiService.readNotifications()
        emit(response)
    }

    suspend fun createNotification(sendNotificationRequestModel: SendNotificationRequestModel): Flow<CommonResponseModel> = flow {
        val response = apiService.createNotification(sendNotificationRequestModel)
        emit(response)
    }


    suspend fun readCourses(commonRequestModel: CommonRequestModel): Flow<CoursesResponseModel> = flow {
        val response = apiService.readCourses(commonRequestModel)
        emit(response)
    }

    suspend fun readSubjects(commonRequestModel: CommonRequestModel): Flow<SubjectsResponseModel> = flow {
        val response = apiService.readSubjects(commonRequestModel)
        emit(response)
    }

    suspend fun addCourse(courseRequestModel: CourseRequestModel): Flow<CommonResponseModel> = flow {
        val response = apiService.addCourses(courseRequestModel)
        emit(response)
    }

    suspend fun addSubject(courseRequestModel: CourseRequestModel): Flow<CommonResponseModel> = flow {
        val response = apiService.addSubject(courseRequestModel)
        emit(response)
    }
}