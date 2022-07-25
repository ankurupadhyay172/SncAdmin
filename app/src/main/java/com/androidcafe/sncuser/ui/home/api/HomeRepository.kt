package com.androidcafe.sncuser.ui.home.api


import com.androidcafe.sncuser.data.request.*
import com.androidcafe.sncuser.data.response.*
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

    suspend fun readStudents(commonRequestModel: CommonRequestModel): Flow<StudentsResponseModel> = flow {
        val response = apiService.readStudents(commonRequestModel)
        emit(response)
    }

    suspend fun readTeachers(commonRequestModel: CommonRequestModel): Flow<TeachersResponseModel> = flow {
        val response = apiService.readTeachers(commonRequestModel)
        emit(response)
    }

    suspend fun addTeacher(addSncUserRequestModel: AddSncUserRequestModel): Flow<CommonResponseModel> = flow {
        val response = apiService.addSncUser(addSncUserRequestModel)
        emit(response)
    }

    suspend fun addStudent(sncUserRequestModel: AddSncUserRequestModel): Flow<CommonResponseModel> = flow {
        val response = apiService.addSncUser(sncUserRequestModel)
        emit(response)
    }


    suspend fun addSncUser(addSncUserRequestModel: AddSncUserRequestModel): Flow<CommonResponseModel> = flow {
        val response = apiService.addSncUser(addSncUserRequestModel)
        emit(response)
    }
}