package com.androidcafe.sncuser.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.databinding.FragmentAdminHomeBinding
import dagger.hilt.android.AndroidEntryPoint

var SELECT_INFO =""
@AndroidEntryPoint
class AdminHomeFragment :BaseFragment<FragmentAdminHomeBinding,HomeViewModel>(){
    val authViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().sentNews.setOnClickListener {
            findNavController().navigate(AdminHomeFragmentDirections.actionAdminHomeFragmentToNotificationsFragment())
        }

        getViewDataBinding().subjectLayout.setOnClickListener {
            findNavController().navigate(AdminHomeFragmentDirections.actionAdminHomeFragmentToCoursesFragment())
        }

        getViewDataBinding().manageStudent.setOnClickListener {
            SELECT_INFO = "student"
            findNavController().navigate(AdminHomeFragmentDirections.actionAdminHomeFragmentToCoursesFragment())
        }
        getViewDataBinding().manageTeachers.setOnClickListener {
            SELECT_INFO = "teacher"
            findNavController().navigate(AdminHomeFragmentDirections.actionAdminHomeFragmentToCoursesFragment())
        }


    }



    override fun getLayoutId() = R.layout.fragment_admin_home
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = authViewModel
}