package com.ankurupadhyay.sncadmin.ui.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.ankurupadhyay.finalljffuser.utils.LoadingState
import com.ankurupadhyay.finalljffuser.utils.toLoadingState
import com.ankurupadhyay.sncadmin.base.BaseViewModel
import com.ankurupadhyay.sncadmin.data.request.CommonRequestModel
import com.ankurupadhyay.sncadmin.data.request.CourseRequestModel
import com.ankurupadhyay.sncadmin.data.request.SendNotificationRequestModel
import com.ankurupadhyay.sncadmin.data.request.UserLoginRequestModel
import com.ankurupadhyay.sncadmin.session.SessionManager
import com.ankurupadhyay.sncadmin.ui.beforestart.api.AuthRepository
import com.ankurupadhyay.sncadmin.ui.home.api.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(@ApplicationContext val context:Context,
                                        val sessionManager: SessionManager,
                                        val repository: HomeRepository):BaseViewModel() {


    val loadState = MutableLiveData<LoadingState>(LoadingState.Loading)


    fun readNotifications()  = liveData(Dispatchers.IO){
        repository.readNotifications().toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            it.getValueOrNull()?.let {
                loadState.postValue(LoadingState.Loaded)
                emit(it)
            }
        }
    }

    fun createNotification(sendNotificationRequestModel: SendNotificationRequestModel)  = liveData(Dispatchers.IO){
        repository.createNotification(sendNotificationRequestModel).toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            it.getValueOrNull()?.let {
                emit(it)
            }
        }
    }

    fun readCourses(commonRequestModel: CommonRequestModel)  = liveData(Dispatchers.IO){
        repository.readCourses(commonRequestModel).toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            it.getValueOrNull()?.let {
                emit(it)
            }
        }
    }

    fun readSubjects(commonRequestModel: CommonRequestModel)  = liveData(Dispatchers.IO){
        repository.readSubjects(commonRequestModel).toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            it.getValueOrNull()?.let {
                emit(it)
            }
        }
    }

    fun addCourse(courseRequestModel: CourseRequestModel)  = liveData(Dispatchers.IO){
        repository.addCourse(courseRequestModel).toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            it.getValueOrNull()?.let {
                emit(it)
            }
        }
    }


    fun addSubject(courseRequestModel: CourseRequestModel)  = liveData(Dispatchers.IO){
        repository.addSubject(courseRequestModel).toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            it.getValueOrNull()?.let {
                emit(it)
            }
        }
    }
}