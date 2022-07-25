package com.androidcafe.sncuser.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.data.adapter.SubjectsAdapter
import com.androidcafe.sncuser.data.request.CommonRequestModel
import com.androidcafe.sncuser.databinding.FragmentNotificationsBinding
import com.androidcafe.sncuser.ui.home.HomeViewModel
import com.androidcafe.sncuser.ui.home.SELECT_INFO
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CourseSubjectFragment :BaseFragment<FragmentNotificationsBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()

    val args:CourseSubjectFragmentArgs by navArgs()
    @Inject
    lateinit var adapter:SubjectsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().lifecycleOwner = this
        getViewDataBinding().rvData.adapter = adapter

        getCourseData()
        showLoading(true)


        getViewDataBinding().fabAdd.setOnClickListener {
            findNavController().navigate(CourseSubjectFragmentDirections.actionCourseSubjectFragmentToAddSubjectFragment(args.id))
        }
    }

    private fun getCourseData() {

        homeViewModel.readSubjects(CommonRequestModel( args.id)).observe(viewLifecycleOwner){
            showLoading(false)
            adapter.submitList(it.result)
        }

        adapter.open = {
            if (SELECT_INFO=="student")
            findNavController().navigate(CourseSubjectFragmentDirections.actionCourseSubjectFragmentToStudentsFragment(args.id,it))
        }

    }


    override fun getLayoutId() = R.layout.fragment_notifications
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}