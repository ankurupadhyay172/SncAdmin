package com.androidcafe.sncuser.ui.beforestart

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.androidcafe.finalljffuser.utils.LoadingState
import com.androidcafe.finalljffuser.utils.toLoadingState
import com.androidcafe.sncuser.base.BaseViewModel
import com.androidcafe.sncuser.data.request.UserLoginRequestModel
import com.androidcafe.sncuser.session.SessionManager
import com.androidcafe.sncuser.ui.beforestart.api.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(@ApplicationContext val context: Context,
                                        val repository: AuthRepository,
                                        val sessionManager: SessionManager):BaseViewModel() {

    val loadState = MutableLiveData<LoadingState>(LoadingState.Loading)


    fun loginUser(userLoginRequestModel: UserLoginRequestModel)  = liveData(Dispatchers.IO){
        loadState.postValue(LoadingState.Loading)
        repository.loginUser(userLoginRequestModel).toLoadingState().catch { e->
            loadState.postValue(LoadingState.Error(e))
        }.collect {
            loadState.postValue(LoadingState.Loaded)
            emit(it)
        }
    }


}