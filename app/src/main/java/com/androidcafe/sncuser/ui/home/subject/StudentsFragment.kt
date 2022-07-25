package com.androidcafe.sncuser.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.data.adapter.StudentsAdapter
import com.androidcafe.sncuser.data.request.CommonRequestModel
import com.androidcafe.sncuser.databinding.FragmentNotificationsBinding
import com.androidcafe.sncuser.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StudentsFragment :BaseFragment<FragmentNotificationsBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter:StudentsAdapter
    val args:StudentsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().lifecycleOwner = this
        getViewDataBinding().rvData.adapter = adapter

        getCourseData()
        showLoading(true)
        getViewDataBinding().fabAdd.setOnClickListener {
            findNavController().navigate(StudentsFragmentDirections.actionStudentsFragmentToAddStudentFragment(args.course,args.year))
        }

    }

    private fun getCourseData() {

        homeViewModel.readStudents(CommonRequestModel( homeViewModel.sessionManager.getUser()?.staff_branch)).observe(viewLifecycleOwner){
            showLoading(false)
            adapter.submitList(it.result)
        }

        adapter.open = {
            findNavController().navigate(CoursesFragmentDirections.actionCoursesFragmentToCourseSubjectFragment(it))
        }

    }


    override fun getLayoutId() = R.layout.fragment_notifications
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}