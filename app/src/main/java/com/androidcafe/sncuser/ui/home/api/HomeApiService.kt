package com.androidcafe.sncuser.ui.home.api

import com.androidcafe.sncuser.data.request.*
import com.androidcafe.sncuser.data.response.*
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

    @POST("readStudents.php")
    suspend fun readStudents(@Body commonrequestmodel: CommonRequestModel):StudentsResponseModel

    @POST("readTeachers.php")
    suspend fun readTeachers(@Body commonrequestmodel: CommonRequestModel):TeachersResponseModel

    @POST("addTeacher.php")
    suspend fun addTeacher(@Body addSncUserRequestModel: AddSncUserRequestModel):CommonResponseModel

    @POST("addStudent.php")
    suspend fun addStudent(@Body addSncUserRequestModel: AddSncUserRequestModel):CommonResponseModel

    @POST("addSncUser.php")
    suspend fun addSncUser(@Body addSncUserRequestModel: AddSncUserRequestModel):CommonResponseModel

}