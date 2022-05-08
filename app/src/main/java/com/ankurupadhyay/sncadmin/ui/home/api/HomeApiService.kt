package com.ankurupadhyay.sncadmin.ui.home.api

import com.ankurupadhyay.sncadmin.data.request.CommonRequestModel
import com.ankurupadhyay.sncadmin.data.request.CourseRequestModel
import com.ankurupadhyay.sncadmin.data.request.SendNotificationRequestModel
import com.ankurupadhyay.sncadmin.data.request.UserLoginRequestModel
import com.ankurupadhyay.sncadmin.data.response.*
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeApiService {

    @POST("readNotifications.php")
    suspend fun readNotifications():UserNotificationResponseModel

    @POST("createNotifications.php")
    suspend fun createNotification(@Body sendNotificationRequestModel: SendNotificationRequestModel):CommonResponseModel

    @POST("readCourses.php")
    suspend fun readCourses(@Body commonrequestmodel:CommonRequestModel):CoursesResponseModel

    @POST("readSubjects.php")
    suspend fun readSubjects(@Body commonrequestmodel:CommonRequestModel):SubjectsResponseModel

    @POST("addCourse.php")
    suspend fun addCourses(@Body courseRequestModel: CourseRequestModel):CommonResponseModel

    @POST("addSubject.php")
    suspend fun addSubject(@Body courseRequestModel: CourseRequestModel):CommonResponseModel
}