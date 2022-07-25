package com.androidcafe.sncuser.ui.teacher

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.databinding.FragmentTeacherHomeBinding
import com.androidcafe.sncuser.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

var SELECT_INFO =""
@AndroidEntryPoint
class AdminHomeFragment :BaseFragment<FragmentTeacherHomeBinding, HomeViewModel>(){
    val authViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



    override fun getLayoutId() = R.layout.fragment_teacher_home
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = authViewModel
}